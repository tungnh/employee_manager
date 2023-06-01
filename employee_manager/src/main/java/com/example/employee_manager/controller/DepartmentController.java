package com.example.employee_manager.controller;


import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String getAll(Pageable pageable, @RequestParam(name = "search", required = false) String search, Model model) {
        Page<DepartmentDTO> departmentDTOS = departmentService.pageAll(search, pageable);
        model.addAttribute("totalPages", departmentDTOS.getTotalPages());
        model.addAttribute("currentPage", departmentDTOS.getNumber());
        model.addAttribute("departmentList", departmentDTOS.getContent());
        return "admin/department/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        departmentService.delete(id);
        model.addAttribute("departmentList", departmentService.getAll());
        return "admin/department/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<EmployeeDTO> employeesList = employeeService.findAll();
        model.addAttribute("employeeList", employeesList);
        model.addAttribute("department", new DepartmentDTO());
        return "admin/department/add";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute DepartmentDTO departmentDTO, Model model) {
        model.addAttribute("departmentList", departmentService.getAll());
        departmentService.save(departmentDTO);
        return "redirect:/department/index";
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<DepartmentDTO> departmentDTO = departmentService.findById(id);
        if (departmentDTO.isPresent()) {
            List<EmployeeDTO> employeesList = employeeService.findAll();
            model.addAttribute("employeeList", employeesList);
            DepartmentDTO departmentDTO1 = departmentDTO.get();
            model.addAttribute("department", departmentDTO1);
            return "admin/department/edit";
        }
        return "admin/department/index";
    }

    @PostMapping("update")
    public String update(@ModelAttribute DepartmentDTO departmentDTO, Model model) {
        DepartmentDTO exit = departmentService.findById(departmentDTO.getId()).get();
        Date createDate = exit.getCreatedDate();
        Integer userId = exit.getId();
        departmentDTO.setCreatedDate(createDate);
        departmentDTO.setId(userId);
        model.addAttribute("departmentList", departmentService.getAll());
        departmentService.update(departmentDTO);
        return "redirect:/department/index";
    }
}