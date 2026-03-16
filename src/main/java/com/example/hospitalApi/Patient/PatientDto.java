package com.example.hospitalApi.Patient;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PatientDto(
        @NotEmpty(message = "Patient name must not be Empty ")
        String patient_name,
        @NotNull(message = "Patient id number must not be Empty ")
        Long national_id_number,
        @NotNull(message = "Patient phone number must not be Empty ")
        Integer phone_number,
        Integer age,
        Double weight,
        Double height,
        Double bmi,
        @NotEmpty(message = "Patient gender must not be Empty ")
        String gender,
        Integer patient_id
) {
    @Override
    public String patient_name() {
        return patient_name;
    }

    @Override
    public Long national_id_number() {
        return national_id_number;
    }

    @Override
    public Integer phone_number() {
        return phone_number;
    }

    @Override
    public Integer age() {
        return age;
    }

    @Override
    public Double weight() {
        return weight;
    }

    @Override
    public Double height() {
        return height;
    }

    @Override
    public Double bmi() {
        return bmi;
    }

    @Override
    public String gender() {
        return gender;
    }


}
