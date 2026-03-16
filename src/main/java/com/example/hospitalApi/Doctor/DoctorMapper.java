package com.example.hospitalApi.Doctor;

import com.example.hospitalApi.Patient.PatientDto;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapper {

    public Doctor toDoctor(DoctorDto dto){
        var doctor = new Doctor();

        doctor.setDoctor_name(dto.doctor_name());
        doctor.setDoctorLicenseNumber(dto.doctorLicenseNumber());
        doctor.setNationalIdNumber(dto.nationalIdNumber());
        doctor.setPhoneNumber(dto.phoneNumber());
        doctor.setSpecialty(dto.Specialty());

        return doctor;


    }

    public DoctorResponseDto todoctorResponseDto (Doctor doctor) {
        return new DoctorResponseDto(
                doctor.getDoctor_id(),
                doctor.getDoctor_name(),
                doctor.getNationalIdNumber(),
                doctor.getDoctorLicenseNumber(),
                doctor.getPhoneNumber(),
                doctor.getSpecialty()
        );
    }
}
