package com.openclassrooms.medilabofront.controller;

import com.openclassrooms.medilabofront.client.medilabonote.model.PatientNote;
import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import com.openclassrooms.medilabofront.model.PatientWithNoteDto;
import com.openclassrooms.medilabofront.service.MedilaboFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedilaboFrontController {

    @Autowired
    private MedilaboFrontService frontService;

    @GetMapping("/login")
    public String homePage() {
        System.out.println("-----------> login page");
        return "login";
    }

    /*@PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model,
                        RedirectAttributes redirectAttributes) {
        System.out.println("-------> go to medilabo");
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);

        //TODO: appel pour valider la connection et générer le token en utilisant la var auth
        String token = "todo";
        redirectAttributes.addAttribute("token", token);

        return "redirect:/medilabo";
    }*/

    @GetMapping("/medilabo")
    public String showMedilaboPage() {
        return "medilabo";
    }

    @GetMapping("/medilabo/patient/list")
    public String patientPage(Model model) {

        List<Patient> patients = frontService.medilaboPatientFindAll();
        List<PatientNote> notes = frontService.medilaboPatientNoteFindAll();

        List<PatientWithNoteDto> patientWithNote = frontService.buildPatientWithNote(patients, notes);

        model.addAttribute("patients", patientWithNote);
        return "patient/list";
    }

    @GetMapping("/medilabo/patient/{id}")
    public String getPatientDetails(@PathVariable Long id, Model model) {
        Patient patient = frontService.medilaboPatientFindById(id);

        List<PatientNote> notes = frontService.medilaboPatientNoteFindAllByPatientId(patient.getId().toString());

        List<PatientWithNoteDto> patientWithNote = frontService.buildPatientWithNote(List.of(patient), notes);

        model.addAttribute("patient", patientWithNote.get(0));
        return "patient/patientFile";
    }

    @PostMapping("/medilabo/updatePatient")
    public String updatePatient(@RequestParam("id") Long patientId, @RequestParam("address") String address,
                                @RequestParam("phoneNumber") String phoneNumber) {
        frontService.medilaboPatientUpdatePatient(patientId, address, phoneNumber);

        return "redirect:/medilabo/patient/" + patientId;
    }
}
