package com.example.employee_manager.controller;


import com.example.employee_manager.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("index")
    public String currency(Model model) {
        model.addAttribute("departmentList", departmentService.getAll());
        return "admin/department/index";
    }
}
