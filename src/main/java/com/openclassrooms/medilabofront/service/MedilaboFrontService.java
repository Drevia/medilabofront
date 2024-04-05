package com.openclassrooms.medilabofront.service;

import com.openclassrooms.medilabofront.client.medilaboService.MedilaboServiceClient;
import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedilaboFrontService {

    @Autowired
    private MedilaboServiceClient client;

    public List<Patient> medilaboPatientFindAll() {
        return client.findAllPatient();
    }
}
