package com.example.employee_manager.controller;

import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/index")
    public String getAll(@RequestParam int page,Model model){
        model.addAttribute("positionList", positionService.getPagingAndSort(page));
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
        model.addAttribute("positionList", positionService.getPagingAndSort(0));
        return "admin/position/index";
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
        positionService.update(positionDTO);
        model.addAttribute("positionList", positionService.getAll());
        return "admin/position/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        positionService.delete(id);
        model.addAttribute("positionList", positionService.getAll());
        return "admin/position/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<PositionDTO> positionDTOList = positionService.searchByName(name);
        model.addAttribute("positionList", positionDTOList);
        return "admin/position/index";
    }
}