package com.example.employee_manager.controller;


import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/index")
    public String currency(Model model) {
        model.addAttribute("departmentList", departmentService.getAll());
        return "admin/department/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model){
        departmentService.delete(id);
        model.addAttribute("departmentList",departmentService.getAll());
        return "admin/department/index";
    }

    @GetMapping("/add")
    public String Add(Model model){
        model.addAttribute("departmentList",departmentService.getAll());
        return "admin/department/add";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute DepartmentDTO departmentDTO,Model model){
        departmentService.save(departmentDTO);
        model.addAttribute("departmentList",departmentService.getAll());
        return "admin/department/index";
    }



}
