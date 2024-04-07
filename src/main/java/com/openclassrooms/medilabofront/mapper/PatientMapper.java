package com.openclassrooms.medilabofront.mapper;

import com.openclassrooms.medilabofront.client.medilaboService.model.Patient;
import com.openclassrooms.medilabofront.client.medilaboService.model.PatientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto patientToDto(Patient patient);
}
