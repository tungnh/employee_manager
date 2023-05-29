package com.example.employee_manager.controller;

import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("admin/position/index");
        mav.addObject("positionList", positionService.getAll());
        return mav;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("position", new PositionDTO());
        return "admin/position/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute PositionDTO positionDTO, Model model) {
        positionService.save(positionDTO);
        model.addAttribute("positionList", positionService.getAll());
        return "redirect:/position/index";
    }
    
    @GetMapping("/update/{id}")
    public String edit(Model model) {
        model.addAttribute("position", new PositionDTO());
        return "admin/position/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute PositionDTO positionDTO, Model model) {
        positionService.update(positionDTO);
        model.addAttribute("positionList", positionService.getAll());
        return "redirect:/position/index";
    }
}
