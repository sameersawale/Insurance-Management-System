package com.example.IMTAssignment.DTOs.InsuranceResponse;

import com.example.IMTAssignment.Enum.InsuranceType;
import com.example.IMTAssignment.Models.Claim;
import com.example.IMTAssignment.Models.Client;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;

import java.time.LocalDate;

public class InsurancePolicyResponseDto {

    private String policyNumber;

    private InsuranceType insuranceType;

    private int coverageAmount;

    private int premium;

    private LocalDate startDate;

    private LocalDate endDate;

    private ClientResponseForInsuranceDto client;

    public InsurancePolicyResponseDto() {
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
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

    public ClientResponseForInsuranceDto getClient() {
        return client;
    }

    public void setClient(ClientResponseForInsuranceDto client) {
        this.client = client;
    }
}
