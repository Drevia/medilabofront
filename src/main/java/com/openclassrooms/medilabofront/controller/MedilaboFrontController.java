package com.openclassrooms.medilabofront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedilaboFrontController {

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping("/patient/list")
    public String patientPage(Model model) {

        return "patient/list";
    }

}
