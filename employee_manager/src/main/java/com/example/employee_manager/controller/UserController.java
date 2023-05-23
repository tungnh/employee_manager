package com.example.employee_manager.controller;

import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private EmployeeService employeeService;

    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        EmployeeDTO employee = new EmployeeDTO();
        model.addAttribute("user", employee);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") EmployeeDTO register) {
        employeeService.save(register);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
