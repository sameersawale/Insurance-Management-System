package com.example.IMTAssignment.DTOs.ClaimResponse;

import com.example.IMTAssignment.Enum.ClaimStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class ClaimResponseDto {

    private String number;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate claimDate;

    private ClaimStatus claimStatus;

    private InsuranceResponseForClaimDto insuranceResponseForClaimDto;

    public ClaimResponseDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public InsuranceResponseForClaimDto getInsuranceResponseForClaimDto() {
        return insuranceResponseForClaimDto;
    }

    public void setInsuranceResponseForClaimDto(InsuranceResponseForClaimDto insuranceResponseForClaimDto) {
        this.insuranceResponseForClaimDto = insuranceResponseForClaimDto;
    }
}
