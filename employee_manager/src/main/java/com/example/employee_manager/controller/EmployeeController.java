package com.example.employee_manager.controller;

import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.dto.EmployeeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public ModelAndView showUserList() {
        ModelAndView mav = new ModelAndView("admin/user/index");
        mav.addObject("userList", employeeService.findAll());
        return mav;
    }

    @GetMapping("/add")
    public String showRegisterForm(Model model) {
        EmployeeDTO employee = new EmployeeDTO();
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