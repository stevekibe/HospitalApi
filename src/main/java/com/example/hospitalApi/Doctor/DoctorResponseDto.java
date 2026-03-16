package com.example.hospitalApi.Doctor;

import jakarta.validation.constraints.NotNull;

public record DoctorResponseDto(
        Integer doctor_id,
        String doctor_name,
        Long nationalIdNumber,
        String doctorLicenseNumber,
        Long phoneNumber,
        Speciality Specialty
) {
}
