package com.example.employee_manager.controller;

import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.PositionDTO;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/index")
    public String getAll(Pageable pageable, @RequestParam(name = "search", required = false) String search, Model model) {
        Page<PositionDTO> positionDTOS = positionService.pageAll(search, pageable);
        model.addAttribute("totalPages", positionDTOS.getTotalPages());
        model.addAttribute("currentPage", positionDTOS.getNumber());
        model.addAttribute("positionList", positionDTOS.getContent());
        return "admin/position/index";
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

    @GetMapping("update/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<PositionDTO> positionDTO1 = positionService.findById(id);
        if (positionDTO1.isPresent()) {
            PositionDTO positionDTO = positionDTO1.get();
            model.addAttribute("position", positionDTO);
            return "admin/position/edit";
        }
        return "admin/position/index";
    }
    @PostMapping("update")
    public String update(@ModelAttribute PositionDTO positionDTO, Model model) {
        PositionDTO exit = positionService.findById(positionDTO.getId()).get();
        Date createDate = exit.getCreatedDate();
        Integer userId = exit.getId();
        positionDTO.setCreatedDate(createDate);
        positionDTO.setId(userId);
        model.addAttribute("positionList", positionService.getAll());
        positionService.update(positionDTO);
        return "redirect:/position/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        positionService.delete(id);
        model.addAttribute("positionList", positionService.getAll());
        return "redirect:/position/index";
    }
}