package com.example.hospitalApi.Patient;

public record PatientResponseDto(
        Integer patient_id,
        String patient_name,
        Long national_id_number,
        Integer phone_number,
        Integer age,
        Double weight,
        Double height,
        Double bmi,
        String gender
) {
}
