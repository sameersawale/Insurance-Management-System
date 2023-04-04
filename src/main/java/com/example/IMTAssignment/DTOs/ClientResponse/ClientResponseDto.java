package com.example.IMTAssignment.DTOs.ClientResponse;

import com.example.IMTAssignment.Models.InsurancePolicy;

import java.time.LocalDate;

public class ClientResponseDto {

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String contact;

    private InsuranceResponseForClientDto insurancePolicy;

    public ClientResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public InsuranceResponseForClientDto getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsuranceResponseForClientDto insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
}
