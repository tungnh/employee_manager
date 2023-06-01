package com.example.employee_manager.controller;

import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.ExperienceRepository;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.ExperienceService;
import com.example.employee_manager.service.dto.CertificateDTO;
import com.example.employee_manager.service.dto.ExperienceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/experience")
public class ExperienceController {
    private final ExperienceService experienceService;
    private final EmployeeService employeeService;
    public ExperienceController(ExperienceService experienceService, EmployeeService employeeService) {
        this.experienceService = experienceService;
        this.employeeService = employeeService;

    }

    @GetMapping("index")
    public String showExperienceList(Model model, @RequestParam(name = "search", required = false) String search, Pageable pageable) {
        Page<ExperienceDTO> experienceDTO = experienceService.findAll(search, pageable);
        model.addAttribute("totalPages", experienceDTO.getTotalPages());
        model.addAttribute("experienceList", experienceDTO.getContent());
        model.addAttribute("currentPage",experienceDTO.getNumber());
        return "user/experience/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        ExperienceDTO experienceDTO = new ExperienceDTO();
        model.addAttribute("experienceAdd", experienceDTO);
        return "user/experience/add";
    }
    @PostMapping("/add")
    public String addExperience(@ModelAttribute("experienceAdd") ExperienceDTO add) {
        experienceService.save(add);
        return "redirect:/experience/index";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView model = new ModelAndView("user/experience/edit");
        Optional<ExperienceDTO> experienceDTO = experienceService.findById(id);
        model.addObject("editExperience", experienceDTO);
        return model;
    }
    @PostMapping("/edit")
    public String editExperience(@ModelAttribute("editCertificate") ExperienceDTO experienceDTO) {
        experienceService.update(experienceDTO);
        return "redirect:/experience/index";
    }

    @GetMapping("/delete")
    public String deleteExperience(@RequestParam int id) {
        experienceService.delete(id);
        return "redirect:/certificate/index";
    }
}
