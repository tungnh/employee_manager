package com.example.employee_manager.controller;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Experience;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, PositionService positionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping("index")
    public String showEmployeeList(Model model, @RequestParam(name = "search", required = false) String search, Pageable pageable) {
        Page<EmployeeDTO> employeeDTOPage = employeeService.findAll(search, pageable);
        model.addAttribute("totalPages", employeeDTOPage.getTotalPages());
        model.addAttribute("employeeList", employeeDTOPage.getContent());
        model.addAttribute("currentPage", employeeDTOPage.getNumber());
        return "admin/user/index";
    }

    @GetMapping("/add")
    public String showRegisterForm(Model model) {
        EmployeeDTO employee = new EmployeeDTO();
        List<DepartmentDTO> departments = departmentService.getAll();
        List<PositionDTO> positions = positionService.getAll();
        model.addAttribute("departmentList", departments);
        model.addAttribute("positionList", positions);
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
        List<DepartmentDTO> departments = departmentService.getAll();
        List<PositionDTO> positions = positionService.getAll();
        model.addObject("departmentList", departments);
        model.addObject("positionList", positions);
        model.addObject("edit", employee.orElse(new EmployeeDTO()));
        return model;
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("edit") EmployeeDTO employeeDTO,
                               @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            String uploadDir = "user-photos/" + employeeDTO.getId();
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = imageFile.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }

            // Lưu đường dẫn tệp tin ảnh vào đối tượng employeeDTO
            employeeDTO.setImgUrl(uploadDir + "/" + fileName);
        }
        employeeService.update(employeeDTO);
        return "redirect:/employee/profile/" + employeeDTO.getId();
    }

    @GetMapping("/profile/{id}")
    public ModelAndView showProfile(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("admin/user/profile");
        Optional<EmployeeDTO> profile = employeeService.findById(id);
        List<Skill> skills = employeeService.getSkillByEmployeeId(id);
        List<Certificate> certificate = employeeService.getCertificateByEmployeeId(id);
        List<Experience> experiences = employeeService.getExceptionByEmployeeId(id);
        modelAndView.addObject("skill", skills);
        modelAndView.addObject("certificate", certificate);
        modelAndView.addObject("experiences", experiences);
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
