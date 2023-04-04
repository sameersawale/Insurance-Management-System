package com.example.IMTAssignment.DTOs.ClientResponse;

import com.example.IMTAssignment.Enum.InsuranceType;

import java.time.LocalDate;

public class InsuranceResponseForClientDto {

    private String number;

    private InsuranceType insuranceType;

    private int coverageAmount;

    private int premium;

    private LocalDate startDate;

    private LocalDate endDate;

    public InsuranceResponseForClientDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
