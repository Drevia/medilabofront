package com.openclassrooms.medilabofront.controller;

import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import com.openclassrooms.medilabofront.service.MedilaboFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
