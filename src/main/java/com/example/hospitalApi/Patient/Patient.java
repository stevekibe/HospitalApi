package com.example.hospitalApi.Patient;


import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Integer patient_id;

    private String patient_name;

    @Column(unique = true, name = "nationalIdNumber")
    private Long national_id_number;
    @Column(unique = true)
    private Integer phone_number;

    private Integer age;
    private Double weight;
    private Double height;
    private Double bmi;
    private String gender;

    @PrePersist
    @PreUpdate
    public void calculateBmi(){
        if (this.height != null && this.weight != null && this.height > 0) {
            double calculatedBmi = this.weight / (this.height * this.height);
            this.bmi = Math.round(calculatedBmi * 100.0) / 100.0;
        }
    }



    public Patient(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Patient(String patient_name, Long nationalIdNumber, Integer age, Double weight, Double height, Double bmi, String gender) {
        this.patient_name = patient_name;
        this.national_id_number = nationalIdNumber;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.gender = gender;
    }

    public Patient() {

    }

    public Integer getPatient_id() {
        return patient_id;
    }

    //getter and setters
    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return patient_name;
    }

    public void setName(String patient_name) {
        this.patient_name = patient_name;
    }

    public Long getNational_id_number() {
        return national_id_number;
    }

    public void setNational_id_number(Long national_id_number) {
        this.national_id_number = national_id_number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }


    //end of getter and setters
}
