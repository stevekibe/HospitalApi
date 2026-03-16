package com.example.hospitalApi.Doctor;

import com.example.hospitalApi.Patient.PatientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private final DoctorRepository repository;

    @Autowired
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository repository, DoctorMapper doctorMapper) {
        this.repository = repository;
        this.doctorMapper = doctorMapper;
    }

    //SAVE DOCTOR
    public DoctorResponseDto addDoctor(DoctorDto dto){
        var doctor = doctorMapper.toDoctor(dto);
        var savedDoctor = repository.save(doctor);

        return doctorMapper.todoctorResponseDto(savedDoctor);
    }

    //DISPLAYING ALL DOCTORS
    public List<DoctorResponseDto> findAllDoctor(){
        return repository.findAll()
                .stream()
                .map(doctorMapper::todoctorResponseDto)
                .toList();
    }

    //FIND BY ID
    public DoctorResponseDto findDoctorById(Integer doctor_id){
        return repository.findById(doctor_id)
                .map(doctorMapper::todoctorResponseDto)
                .orElseThrow();
    }

    //UPDATING A PATIENT
    public DoctorResponseDto updateDoctor(Integer doctor_id, DoctorDto dto){

        var existingDoctor = repository.findById(doctor_id)
                .orElseThrow();

        existingDoctor.setDoctor_name(dto.doctor_name());
        existingDoctor.setNationalIdNumber(dto.nationalIdNumber());
        existingDoctor.setDoctorLicenseNumber(dto.doctorLicenseNumber());
        existingDoctor.setSpecialty(dto.Specialty());
        existingDoctor.setPhoneNumber(dto.phoneNumber());

        var updateDoctor = repository.save(existingDoctor);

        return doctorMapper.todoctorResponseDto(updateDoctor);

    }

    public void delete(Integer doctor_id){
        repository.deleteById(doctor_id);
    }

}
