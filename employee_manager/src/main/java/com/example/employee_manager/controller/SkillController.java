package com.example.employee_manager.controller;

import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.SkillService;
import com.example.employee_manager.service.dto.SkillDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;
    private final EmployeeService employeeService;

    public SkillController(SkillService skillService, EmployeeService employeeService) {
        this.skillService = skillService;
        this.employeeService = employeeService;
    }

    @GetMapping("index")
    public String showSkill(Model model, @RequestParam(name = "search", required = false) String search, Pageable pageable) {
        Page<SkillDTO> skillDTO = skillService.findAll(search, pageable);
        model.addAttribute("totalPages", skillDTO.getTotalPages());
        model.addAttribute("skillList", skillDTO.getContent());
        model.addAttribute("currentPage",skillDTO.getNumber());
        return "user/skill/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        SkillDTO skillDTO = new SkillDTO();
        model.addAttribute("skillAdd", skillDTO);
        return "user/skill/add";
    }
    @PostMapping("/add")
    public String addSkill(@ModelAttribute("skillAdd") SkillDTO add) {
        skillService.save(add);
        return "redirect:/skill/index";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView model = new ModelAndView("user/skill/edit");
        Optional<SkillDTO> skillDTO = skillService.findById(id);
        model.addObject("editSkill", skillDTO);
        return model;
    }
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("editSkill") SkillDTO skillDTO) {
        skillService.update(skillDTO);
        return "redirect:/skill/index";
    }
    @GetMapping("/delete")
    public String deleteSkill(@RequestParam int id) {
        skillService.delete(id);
        return "redirect:/skill/index";
    }
}
