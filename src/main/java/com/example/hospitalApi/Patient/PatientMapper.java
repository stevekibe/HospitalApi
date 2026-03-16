package com.example.hospitalApi.Patient;


import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient toPatient(PatientDto dto){
        var patient = new Patient();
        patient.setName(dto.patient_name());
        patient.setNational_id_number(dto.national_id_number());
        patient.setPhone_number(dto.phone_number());
        patient.setAge(dto.age());
        patient.setWeight(dto.weight());
        patient.setHeight(dto.height());

        patient.setGender(dto.gender());

        return patient;
    }

    public PatientResponseDto toPatientResponseDto(Patient patient) {
        return new PatientResponseDto(
                patient.getPatient_id(),
                patient.getName(),
                patient.getNational_id_number(),
                patient.getPhone_number(),
                patient.getAge(),
                patient.getWeight(),
                patient.getHeight(), patient.getBmi(), patient.getGender()
        );
    }
}
