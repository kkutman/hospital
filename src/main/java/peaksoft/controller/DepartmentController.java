package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
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
    public String deleteHospital(@PathVariable("departmentId")Long id){
        departmentServices.deleteDepartmentById(id);
        return "redirect:/department";
    }





















    @GetMapping("{departmentId}/editDepartment")
    public String editHospital(@PathVariable("departmentId")Long departmentId,Model model){
        model.addAttribute("newUpdateDepartment",departmentServices.getDepartmentById(departmentId));
        return "updateHospital";
    }

    @PatchMapping("{hospitalId}/updateHospital")
    public String updateHospital(@PathVariable("hospitalId")Long id,@ModelAttribute("newUpdateHospital") Hospital hospital){
        hospitalServices.updateHospitalId(hospital,id);
        return "redirect:/hospital";
    }



}
