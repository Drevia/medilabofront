package com.openclassrooms.medilabofront.client.medilabonote;

import com.openclassrooms.medilabofront.client.medilabonote.model.PatientNote;
import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "http://localhost:8090/api", name = "MedilaboNote")
public interface MedilaboNoteGatewayClient {

    @GetMapping("/note")
    List<PatientNote> findAllPatientNote(@RequestHeader(value = "Authorization") String header);

    @GetMapping("/note/{id}")
    List<PatientNote> findAllPatientNoteByPatientId(@RequestHeader(value = "Authorization") String header,
                                                    @PathVariable String id);
}
