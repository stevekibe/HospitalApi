package com.example.hospitalApi.Doctor;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DoctorDto(
        @NotEmpty(message = "Doctor name must not be empty")
        String doctor_name,
        @NotNull
        Long nationalIdNumber,
        @NotNull
        String doctorLicenseNumber,
        @NotNull
        Long phoneNumber,
        Speciality Specialty

) {


}
