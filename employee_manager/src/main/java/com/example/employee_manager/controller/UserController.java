package com.example.employee_manager_pr.controller;

import com.example.employee_manager_pr.dto.request.RegisterRequest;
import com.example.employee_manager_pr.model.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private EmployeeService employeeService;

    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("user")
    public RegisterRequest registerRequest() {
        return new RegisterRequest();
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/create")
    public String registerUser(@ModelAttribute("user")RegisterRequest registerRequest) {
        employeeService.save(registerRequest);
        return "redirect:/auth/register?success";
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
