package com.example.hospitalApi.Patient;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {



    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping("/addpatient")
    public PatientResponseDto savePatient(
            @Valid @RequestBody PatientDto dto
    ){
        return this.patientService.addPatient(dto);
    }

    //getting all patients
    @GetMapping("/patients")
    public List<PatientResponseDto> findAllPatient(){
        return patientService.findAllPatient();
    }

    //perfoming search by id
    @GetMapping("/patients/{patient_id}")
    public PatientResponseDto findPatientById(@PathVariable("patient_id") Integer patient_id){
        return patientService.findPatientById(patient_id);
    }

    //updating patient details
    @PutMapping("/patients/{patient_id}")
    public PatientResponseDto updatePatient(
            @PathVariable("patient_id") Integer patient_id,
            @RequestBody PatientDto dto
    ) {
        return patientService.upadatePatient(patient_id, dto);
    }


    @DeleteMapping("/patients/{patient_id}")
    public void delete(
            @PathVariable("patient_id") Integer patient_id
    ){
        patientService.delete(patient_id);
    }

}
