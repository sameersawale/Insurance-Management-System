package com.example.IMTAssignment.Service;

import com.example.IMTAssignment.DTOs.InsurancePolicyDto;
import com.example.IMTAssignment.DTOs.InsurancePolicyUpdateReqDto;
import com.example.IMTAssignment.DTOs.InsuranceResponse.InsurancePolicyResponseDto;

import java.util.List;

public interface InsuranceService {

    public abstract String addInsurancePolicy(InsurancePolicyDto insurancePolicyDto) throws Exception;

    public abstract InsurancePolicyResponseDto getInsurance(Integer id) throws Exception;

    public abstract List<InsurancePolicyResponseDto> getAllInsurancePolicies() throws Exception;

    public abstract String deletePolicy(Integer id) throws Exception;

    public abstract String updatePolicy(Integer id, InsurancePolicyUpdateReqDto insurancePolicyUpdateReqDto) throws Exception;
}
