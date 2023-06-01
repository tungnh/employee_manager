package com.example.employee_manager.controller;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.ProjectService;
import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String getAll(Pageable pageable, @RequestParam(name = "search", required = false) String search, Model model) {
        Page<ProjectDTO> projectDTOS = projectService.pageAll(search, pageable);
        model.addAttribute("totalPages", projectDTOS.getTotalPages());
        model.addAttribute("currentPage", projectDTOS.getNumber());
        model.addAttribute("projectList", projectDTOS.getContent());
        return "admin/project/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<EmployeeDTO> employeesList = employeeService.findAll();
        model.addAttribute("employeeList", employeesList);
        model.addAttribute("project", new ProjectDTO());
        return "admin/project/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute ProjectDTO projectDTO, Model model) {
        projectService.save(projectDTO);
        model.addAttribute("projectList", projectService.getAll());
        return "redirect:/project/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        projectService.delete(id);
        model.addAttribute("projectList", projectService.getAll());
        return "redirect:/project/index";
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<ProjectDTO> projectDTO1 = projectService.findById(id);
        if (projectDTO1.isPresent()) {
            ProjectDTO projectDTO = projectDTO1.get();
            List<EmployeeDTO> employeesList = employeeService.findAll();
            model.addAttribute("employeeList", employeesList);
            model.addAttribute("project", projectDTO);
            return "admin/project/edit";
        }
        return "admin/project/index";
    }

    @PostMapping("update")
    public String update(@ModelAttribute ProjectDTO projectDTO, Model model) {
        ProjectDTO exit = projectService.findById(projectDTO.getId()).get();
        Date createDate = exit.getCreatedDate();
        Integer userId = exit.getId();
        projectDTO.setCreatedDate(createDate);
        projectDTO.setId(userId);
        model.addAttribute("projectList", projectService.getAll());
        projectService.update(projectDTO);
        return "redirect:/project/index";
    }
}