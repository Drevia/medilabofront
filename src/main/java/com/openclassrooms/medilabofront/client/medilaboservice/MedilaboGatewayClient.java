package com.openclassrooms.medilabofront.client.medilaboservice;

import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import com.openclassrooms.medilabofront.client.medilaboservice.model.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "http://localhost:8090/api", name = "MedilaboPatient")
public interface MedilaboGatewayClient {

    @GetMapping("/patient")
    List<Patient> findAllPatient(@RequestHeader(value = "Authorization") String header);

    @GetMapping("/patient/{id}")
    Patient findPatientById(@RequestHeader(value = "Authorization")String header, @PathVariable Long id);

    @PatchMapping("/patient/{id}")
    Patient updatePatient(PatientDto patient, @PathVariable Long id);
}
