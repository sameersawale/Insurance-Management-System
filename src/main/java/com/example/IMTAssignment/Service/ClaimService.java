package com.example.IMTAssignment.Service;

import com.example.IMTAssignment.DTOs.ClaimDto;
import com.example.IMTAssignment.DTOs.ClaimResponse.ClaimResponseDto;
import com.example.IMTAssignment.DTOs.ClaimUpdateReqDto;

import java.util.List;

public interface ClaimService {

    public abstract String addClaim(ClaimDto claimDto) throws Exception;

    public abstract ClaimResponseDto getClaimById(Integer id) throws Exception;

    public abstract List<ClaimResponseDto> getAllClaims() throws Exception;

    public abstract String deleteClaim(Integer id) throws Exception;

    public abstract String updateClaim(Integer id, ClaimUpdateReqDto claimUpdateReqDto) throws Exception;
}
