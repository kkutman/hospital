package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.services.DepartmentServices;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentServices departmentServices;
    private final HospitalServices hospitalServices;
    @GetMapping
    public String get(Model model){
        model.addAttribute("getAllDepartment",departmentServices.getAllDepartment());
        return "department";
    }

}
