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
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalServices hospitalServices;
    private final DepartmentServices departmentServices;

    @GetMapping
    public String getAllHospital(Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "hospital";
    }

    @GetMapping("/saveHospital")
    public String saveHospital(Model model){
        model.addAttribute("newHospital",new Hospital());
        return "addHospital";
    }

    @PostMapping("/createHospital")
    public String createHospital(@ModelAttribute("newHospital")Hospital hospital){
        hospitalServices.saveHospital(hospital);
        return "redirect:/hospital";
    }

    @DeleteMapping("{hospitalId}/deleteHospital")
    public String deleteHospital(@PathVariable("hospitalId")Long id){
        hospitalServices.deleteHospitalById(id);
        return "redirect:/hospital";
    }

    @GetMapping("{hospitalId}/editHospital")
    public String editHospital(@PathVariable("hospitalId")Long hospitalId,Model model){
        model.addAttribute("newUpdateHospital",hospitalServices.getHospitalById(hospitalId));
        return "updateHospital";
    }

    @PatchMapping("{hospitalId}/updateHospital")
    public String updateHospital(@PathVariable("hospitalId")Long id,@ModelAttribute("newUpdateHospital")Hospital hospital){
        hospitalServices.updateHospitalId(hospital,id);
        return "redirect:/hospital";
    }

}
