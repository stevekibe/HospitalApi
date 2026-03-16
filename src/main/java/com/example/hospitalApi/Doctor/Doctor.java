package com.example.hospitalApi.Doctor;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Integer doctor_id;
    private String doctor_name;

    @Column(unique = true)
    private Long nationalIdNumber;
    @Column(unique = true)
    private String doctorLicenseNumber;
    @Column(unique = true)
    private Long phoneNumber;

    private Speciality Specialty;

    //Constructor
    public Doctor() {
    }

    public Doctor(String doctor_name, Long nationalIdNumber, String doctorLicenseNumber, Long phoneNumber, Speciality specialty) {
        this.doctor_name = doctor_name;
        this.nationalIdNumber = nationalIdNumber;
        this.doctorLicenseNumber = doctorLicenseNumber;
        this.phoneNumber = phoneNumber;
        Specialty = specialty;
    }

    //end of constructor


    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Long getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(Long nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getDoctorLicenseNumber() {
        return doctorLicenseNumber;
    }

    public void setDoctorLicenseNumber(String doctorLicenseNumber) {
        this.doctorLicenseNumber = doctorLicenseNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Speciality getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(Speciality specialty) {
        Specialty = specialty;
    }
}
