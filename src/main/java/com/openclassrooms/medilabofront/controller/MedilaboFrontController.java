package com.openclassrooms.medilabofront.controller;

import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import com.openclassrooms.medilabofront.service.MedilaboFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedilaboFrontController {

    @Autowired
    private MedilaboFrontService frontService;

    @GetMapping("/")
    public String homePage() {
        return "medilabo";
    }

    @GetMapping("/medilabo/patient/list")
    public String patientPage(Model model) {
        List<Patient> patients = frontService.medilaboPatientFindAll();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping("/medilabo/patient/{id}")
    public String getPatientDetails(@PathVariable Long id, Model model) {
        Patient patient = frontService.medilaboPatientFindById(id);

        model.addAttribute("patient", patient);
        return "patient/patientFile";
    }

    @PostMapping("/medilabo/updatePatient")
    public String updatePatient(@RequestParam("id") Long patientId, @RequestParam("address") String address,
                                @RequestParam("phoneNumber") String phoneNumber) {
        frontService.medilaboPatientUpdatePatient(patientId, address, phoneNumber);

        return "redirect:/medilabo/patient/" + patientId;
    }
}
