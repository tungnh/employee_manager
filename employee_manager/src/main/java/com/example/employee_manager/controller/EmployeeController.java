package com.example.employee_manager.controller;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.PositionRepository;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.CertificateDTO;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, PositionService positionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping("index")
    public String showEmployeeList(Model model, @RequestParam(name = "search", required = false) String search, Pageable pageable) {
        Page<EmployeeDTO> employeeDTOPage = employeeService.findAll(search, pageable);
        model.addAttribute("totalPages", employeeDTOPage.getTotalPages());
        model.addAttribute("employeeList", employeeDTOPage.getContent());
        model.addAttribute("currentPage", employeeDTOPage.getNumber());
        return "admin/user/index";
    }

    @GetMapping("/add")
    public String showRegisterForm(Model model) {
        EmployeeDTO employee = new EmployeeDTO();
        List<DepartmentDTO> departments = departmentService.getAll();
        List<PositionDTO> positions = positionService.getAll();
        model.addAttribute("departmentList", departments);
        model.addAttribute("positionList", positions);
        model.addAttribute("user", employee);
        return "admin/user/add";
    }

    @PostMapping("/add")
    public String registerUser(@ModelAttribute("user") EmployeeDTO register) {
        employeeService.save(register);
        return "redirect:/employee/index";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView model = new ModelAndView("admin/user/edit");
        Optional<EmployeeDTO> employee = employeeService.findById(id);
        List<DepartmentDTO> departments = departmentService.getAll();
        List<PositionDTO> positions = positionService.getAll();
        model.addObject("departmentList", departments);
        model.addObject("positionList", positions);
        model.addObject("edit", employee.orElse(new EmployeeDTO()));
        return model;
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("edit") EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
        return "redirect:/employee/profile/" + employeeDTO.getId();
    }

    @GetMapping("/profile/{id}")
    public ModelAndView showProfile(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("admin/user/profile");
        Optional<EmployeeDTO> profile = employeeService.findById(id);
        modelAndView.addObject("profileUser", profile);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        employeeService.delete(id);
        return "redirect:/employee/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
