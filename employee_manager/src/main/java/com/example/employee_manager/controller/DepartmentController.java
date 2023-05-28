package com.example.employee_manager.controller;


import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        model.addAttribute("department",new DepartmentDTO());
        return "admin/department/add";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute DepartmentDTO departmentDTO,Model model){
        departmentService.save(departmentDTO);
        model.addAttribute("departmentList",departmentService.getAll());
        return "admin/department/index";
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<DepartmentDTO> departmentDTO = departmentService.findById(id);
        if (departmentDTO.isPresent()) {
            DepartmentDTO departmentDTO1 = departmentDTO.get();
            model.addAttribute("department", departmentDTO1);
            return "admin/department/edit";
        }
        return "admin/department/index";
    }

    @PostMapping("update")
    public String updateWallet(@ModelAttribute DepartmentDTO departmentDTO, Model model) {
        departmentService.update(departmentDTO);
        model.addAttribute("departmentList", departmentService.getAll());
        return "admin/department/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name,Model model){
        List<DepartmentDTO> departmentDTOList = departmentService.searchByName(name);
        model.addAttribute("departmentList",departmentDTOList);
        return "admin/department/index";
    }
}
