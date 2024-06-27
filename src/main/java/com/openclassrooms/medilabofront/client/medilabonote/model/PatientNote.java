package com.openclassrooms.medilabofront.client.medilabonote.model;

import lombok.Getter;

@Getter
public class PatientNote {

    private String id;
    private String patientId;
    private String patientName;
    private String note;
}
