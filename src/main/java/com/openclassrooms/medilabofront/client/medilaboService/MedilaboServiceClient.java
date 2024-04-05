package com.openclassrooms.medilabofront.client.medilaboService;

import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import com.openclassrooms.medilabofront.client.medilaboService.model.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8091/")
public interface MedilaboServiceClient {

    @GetMapping("/patient")
    List<Patient> findAllPatient();
}
