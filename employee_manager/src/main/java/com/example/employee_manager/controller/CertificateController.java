package com.example.employee_manager.controller;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.CertificateRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.CertificateService;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.dto.CertificateDTO;
import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/certificate")
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping("/index")
    public ModelAndView showCertificateList() {
        ModelAndView mav = new ModelAndView("user/certificate/index");
        mav.addObject("certificateList", certificateService.findAll());
        return mav;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        CertificateDTO certificateDTO = new CertificateDTO();
        model.addAttribute("certificateAdd", certificateDTO);
        return "user/certificate/add";
    }

    @PostMapping("/add")
    public String addCertificate(@ModelAttribute("certificateAdd") CertificateDTO add) {
        certificateService.save(add);
        return "redirect:/certificate/index";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView model = new ModelAndView("user/certificate/edit");
        Optional<CertificateDTO> certificateDTO = certificateService.findById(id);
        model.addObject("editCertificate", certificateDTO);
        return model;
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("editCertificate") CertificateDTO certificateDTO) {
        certificateService.update(certificateDTO);
        return "redirect:/certificate/index";
    }

    @GetMapping("/delete")
    public String deleteCertificate(@RequestParam int id) {
        certificateService.delete(id);
        return "redirect:/certificate/index";
    }
}
