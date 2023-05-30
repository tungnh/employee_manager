package com.example.employee_manager.controller;

import com.example.employee_manager.service.ProjectService;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("projectList",projectService.getAll());
        return "admin/project/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("project", new ProjectDTO());
        return "admin/project/add";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute ProjectDTO projectDTO,Model model){
        projectService.save(projectDTO);
        model.addAttribute("projectList",projectService.getAll());
        return "admin/project/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id,Model model){
        projectService.delete(id);
        model.addAttribute("projectList",projectService.getAll());
        return "admin/project/index";
    }

    @GetMapping("search")
    public String search(@RequestParam("name")String name, Model model){
        List<ProjectDTO> projectDTOList = projectService.searchByName(name);
        model.addAttribute("projectList",projectDTOList);
        return "admin/project/index";
    }
    @GetMapping("update/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<ProjectDTO> projectDTO1 = projectService.findById(id);
        if (projectDTO1.isPresent()) {
            ProjectDTO projectDTO = projectDTO1.get();
            model.addAttribute("project", projectDTO);
            return "admin/project/edit";
        }
        return "admin/project/index";
    }

    @PostMapping("update")
    public String updateCurrency(@ModelAttribute ProjectDTO projectDTO, Model model) {
        projectService.update(projectDTO);
        model.addAttribute("projectList", projectService.getAll());
        return "admin/project/index";
    }
}
