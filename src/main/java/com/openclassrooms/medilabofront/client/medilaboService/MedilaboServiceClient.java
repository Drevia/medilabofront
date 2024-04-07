package com.openclassrooms.medilabofront.client.medilaboService;

import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import com.openclassrooms.medilabofront.client.medilaboService.model.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8091/", name = "MedilaboPatient")
public interface MedilaboServiceClient {

    @GetMapping("/patient")
    List<Patient> findAllPatient();

    @GetMapping("/patient/{id}")
    Patient findPatientById(@PathVariable Long id);

    @PatchMapping("/patient/{id}")
    Patient updatePatient(PatientDto patient, @PathVariable Long id);
}
