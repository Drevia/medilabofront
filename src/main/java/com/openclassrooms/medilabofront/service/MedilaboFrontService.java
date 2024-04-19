package com.openclassrooms.medilabofront.service;

import com.openclassrooms.medilabofront.client.medilaboservice.MedilaboServiceClient;
import com.openclassrooms.medilabofront.client.medilaboservice.model.Patient;
import com.openclassrooms.medilabofront.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedilaboFrontService {

    @Autowired
    private MedilaboServiceClient client;

    @Autowired
    private PatientMapper mapper;

    public List<Patient> medilaboPatientFindAll() {
        return client.findAllPatient();
    }

    public Patient medilaboPatientFindById(Long id) {
        return client.findPatientById(id);
    }

    public void medilaboPatientUpdatePatient(Long patientId, String address, String phoneNumber) {
        Patient patient = medilaboPatientFindById(patientId);
        patient.setAddress(address);
        patient.setPhoneNumber(phoneNumber);
        client.updatePatient(mapper.patientToDto(patient), patientId);
    }
}
