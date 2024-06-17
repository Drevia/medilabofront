package com.openclassrooms.medilabofront.service;

import com.openclassrooms.medilabofront.client.medilaboservice.MedilaboGatewayClient;
import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import com.openclassrooms.medilabofront.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedilaboFrontService {

    @Autowired
    private MedilaboGatewayClient gatewayClient;

    @Autowired
    private PatientMapper mapper;

    public List<Patient> medilaboPatientFindAll(Authentication auth) {



        return gatewayClient.findAllPatient();
    }

    public Patient medilaboPatientFindById(Long id) {
        return gatewayClient.findPatientById(id);
    }

    public void medilaboPatientUpdatePatient(Long patientId, String address, String phoneNumber) {
        Patient patient = medilaboPatientFindById(patientId);
        patient.setAddress(address);
        patient.setPhoneNumber(phoneNumber);
        gatewayClient.updatePatient(mapper.patientToDto(patient), patientId);
    }
}
