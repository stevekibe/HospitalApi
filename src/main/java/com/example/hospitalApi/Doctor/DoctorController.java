package com.example.hospitalApi.Doctor;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctor")
    public DoctorResponseDto saveDoctor(
            @Valid @RequestBody DoctorDto  dto
    ){
        return this.doctorService.addDoctor(dto);
    }

    @GetMapping("/doctor")
    public List<DoctorResponseDto> findAllDoctor(){
        return doctorService.findAllDoctor();
    }

    @DeleteMapping("/doctor/{doctor_id}")
    public void delete(
            @PathVariable("doctor_id") Integer doctor_id
    ){
        doctorService.delete(doctor_id);
    }



}
