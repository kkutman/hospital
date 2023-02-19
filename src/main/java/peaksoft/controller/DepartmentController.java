package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
import peaksoft.services.DepartmentServices;
import peaksoft.services.HospitalServices;

import java.util.List;

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
    public String getAllDepartment(Model model){
        model.addAttribute("getAllDepartment",departmentServices.getAllDepartment());
        return "department";
    }
    @GetMapping("/getAllHospital")
    public String getAllHospital(Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "saveDepartment";
    }

    @GetMapping("/saveDepartment")
    public String saveDepartment(Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "saveDepartment";
    }
    @GetMapping("{id}/saves")
    public String saves(Model model){
        model.addAttribute("department",new Department());
        return "saves";
    }

    @PostMapping("{hospitalId}/createDepartment")
    public String createDepartment(@PathVariable("hospitalId")Long id,@ModelAttribute("department")Department department){
        department.setHospital(hospitalServices.getHospitalById(id));
        departmentServices.saveDepartment(department);
        return "redirect:/department";

    }

    @DeleteMapping("{departmentId}/deleteDepartment")
    public String deleteHospital(@PathVariable("departmentId")Long id) {
        departmentServices.deleteDepartmentById(id);
        return "redirect:/department";
    }

    @GetMapping("{departmentId}/editDepartment")
    public String editDepartment(@PathVariable("departmentId")Long id,Model model){
        model.addAttribute("newUpdateDepartment",departmentServices.getDepartmentById(id));
        return "updateDepartment";
    }
    @PostMapping("{departmentId}/updateDepartment")
    public String updateDepartment(@PathVariable("departmentId")Long id,@ModelAttribute("newUpdateDepartment")Department department){
        departmentServices.updateDepartmentId(id,department);
        return "redirect:/department";
    }









}
