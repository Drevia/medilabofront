package com.openclassrooms.medilabofront.controller;

import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import com.openclassrooms.medilabofront.service.MedilaboFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedilaboFrontController {

    @Autowired
    MedilaboFrontService frontService;

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/patient/list")
    public String patientPage(Model model) {
        List<Patient> patients = frontService.medilaboPatientFindAll();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping("/patient/{id}")
    public String getPatientDetails(@PathVariable Long id, Model model) {
        Patient patient = frontService.medilaboPatientFindById(id);

        model.addAttribute("patient", patient);
        return "patient/patientFile";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@RequestParam("id") Long patientId, @RequestParam("address") String address,
                                @RequestParam("phoneNumber") String phoneNumber) {
        frontService.medilaboPatientUpdatePatient(patientId, address, phoneNumber);

        return "redirect:/patient/" + patientId;
    }
}
