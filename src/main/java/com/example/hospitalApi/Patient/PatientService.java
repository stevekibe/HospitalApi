package com.example.hospitalApi.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository repository;

    @Autowired
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository repository, PatientMapper patientMapper) {
        this.repository = repository;
        this.patientMapper = patientMapper;
    }

    //saving Patients
    public PatientResponseDto addPatient(PatientDto dto){

        var patient = patientMapper.toPatient(dto);
        var savedPateint = repository.save(patient);

        return patientMapper.toPatientResponseDto(savedPateint);
    }

    //getting patients
    public List<PatientResponseDto> findAllPatient(){
        return repository.findAll()
                .stream()
                .map(patientMapper::toPatientResponseDto)
                .toList();
    }

    //finding patient by id
    public PatientResponseDto findPatientById(Integer patient_id){
        return repository.findById(patient_id)
                .map(patientMapper::toPatientResponseDto)
                .orElseThrow();
    }

    //update patient
    public PatientResponseDto upadatePatient(Integer patient_id, PatientDto dto){

        var existingPatient = repository.findById(patient_id)
                .orElseThrow(() -> new RuntimeException("Patient with " + patient_id + " not found"));

        existingPatient.setName(dto.patient_name());
        existingPatient.setNational_id_number(dto.national_id_number());
        existingPatient.setPhone_number(dto.phone_number());
        existingPatient.setAge(dto.age());
        existingPatient.setWeight(dto.weight());
        existingPatient.setHeight(dto.height());
        existingPatient.setGender(dto.gender());

        var updatePatient = repository.save(existingPatient);

        return patientMapper.toPatientResponseDto(updatePatient);
    }

    public void delete(Integer patient_id){
        repository.deleteById(patient_id);
    }

}
