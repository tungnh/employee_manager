package com.example.employee_manager.controller;

import com.example.employee_manager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/currency")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/userList")
    public ModelAndView showUserList() {
        ModelAndView mav = new ModelAndView("user-list");
        mav.addObject("user",employeeService.findAll());
        return mav;
    }
}
