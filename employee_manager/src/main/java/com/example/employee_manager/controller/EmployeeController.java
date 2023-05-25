package com.example.employee_manager.controller;

import com.example.employee_manager.service.EmployeeService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/userList")
    public ModelAndView showUserList(Pageable pageable) {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("user", employeeService.findAll(pageable));
        return mav;
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
