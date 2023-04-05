package com.example.IMTAssignment.Service.ServiceImpl;

import com.example.IMTAssignment.DTOs.ClaimDto;
import com.example.IMTAssignment.DTOs.ClaimResponse.ClaimResponseDto;
import com.example.IMTAssignment.DTOs.ClaimResponse.InsuranceResponseForClaimDto;
import com.example.IMTAssignment.DTOs.ClaimUpdateReqDto;
import com.example.IMTAssignment.Models.Claim;
import com.example.IMTAssignment.Models.InsurancePolicy;
import com.example.IMTAssignment.Repository.ClaimRepository;
import com.example.IMTAssignment.Repository.InsuranceRepository;
import com.example.IMTAssignment.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    ClaimRepository claimRepository;

    @Override
    public String addClaim(ClaimDto claimDto) throws Exception {

        InsurancePolicy insurancePolicy=insuranceRepository.findByPolicyNumber(claimDto.getPolicyNumber());

        Claim claim=new Claim();

        claim.setNumber(claimDto.getNumber());
        claim.setDescription(claimDto.getDescription());
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimStatus(claimDto.getClaimStatus());
        claim.setInsurancePolicy(insurancePolicy);

        insurancePolicy.setClaim(claim);

        insuranceRepository.save(insurancePolicy);

        return "Claim request added";
    }

    @Override
    public ClaimResponseDto getClaimById(Integer id) throws Exception {

        Claim claim=claimRepository.findById(id).get();

        ClaimResponseDto claimResponseDto=new ClaimResponseDto();

        InsuranceResponseForClaimDto insuranceResponseForClaimDto=new InsuranceResponseForClaimDto();

        insuranceResponseForClaimDto.setPolicyNumber(claim.getInsurancePolicy().getPolicyNumber());
        insuranceResponseForClaimDto.setInsuranceType(claim.getInsurancePolicy().getType());
        insuranceResponseForClaimDto.setCoverageAmount(claim.getInsurancePolicy().getCoverageAmount());
        insuranceResponseForClaimDto.setPremium(claim.getInsurancePolicy().getPremium());
        insuranceResponseForClaimDto.setStartDate(claim.getInsurancePolicy().getStartDate());
        insuranceResponseForClaimDto.setEndDate(claim.getClaimDate());

        claimResponseDto.setNumber(claim.getNumber());
        claimResponseDto.setClaimDate(claim.getClaimDate());
        claimResponseDto.setDescription(claim.getDescription());
        claimResponseDto.setClaimStatus(claim.getClaimStatus());

        claimResponseDto.setInsuranceResponseForClaimDto(insuranceResponseForClaimDto);

        return claimResponseDto;

    }

    @Override
    public List<ClaimResponseDto> getAllClaims() throws Exception {
        List<Claim> claimList=claimRepository.findAll();

        List<ClaimResponseDto>claimResponseDtoList=new ArrayList<>();

        for(Claim claim:claimList){
            ClaimResponseDto claimResponseDto=new ClaimResponseDto();

            InsuranceResponseForClaimDto insuranceResponseForClaimDto=new InsuranceResponseForClaimDto();

            insuranceResponseForClaimDto.setPolicyNumber(claim.getInsurancePolicy().getPolicyNumber());
            insuranceResponseForClaimDto.setInsuranceType(claim.getInsurancePolicy().getType());
            insuranceResponseForClaimDto.setCoverageAmount(claim.getInsurancePolicy().getCoverageAmount());
            insuranceResponseForClaimDto.setPremium(claim.getInsurancePolicy().getPremium());
            insuranceResponseForClaimDto.setStartDate(claim.getInsurancePolicy().getStartDate());
            insuranceResponseForClaimDto.setEndDate(claim.getClaimDate());

            claimResponseDto.setNumber(claim.getNumber());
            claimResponseDto.setClaimDate(claim.getClaimDate());
            claimResponseDto.setDescription(claim.getDescription());
            claimResponseDto.setClaimStatus(claim.getClaimStatus());

            claimResponseDto.setInsuranceResponseForClaimDto(insuranceResponseForClaimDto);

            claimResponseDtoList.add(claimResponseDto);
        }
        return claimResponseDtoList;
    }

    @Override
    public String deleteClaim(Integer id) throws Exception {
        Claim claim=claimRepository.findById(id).get();
        claimRepository.delete(claim);
        InsurancePolicy insurancePolicy=claim.getInsurancePolicy();
        insurancePolicy.setClaim(claim);
        return "claim delete successfully...";
    }

    @Override
    public String updateClaim(Integer id, ClaimUpdateReqDto claimUpdateReqDto) throws Exception {

        Claim claim=claimRepository.findById(id).get();

        int policyId=claim.getInsurancePolicy().getId();

        InsurancePolicy insurancePolicy=insuranceRepository.findById(policyId).get();

        claim.setDescription(claimUpdateReqDto.getDescription());
        claim.setClaimStatus(claimUpdateReqDto.getClaimStatus());
        claim.setClaimDate(claimUpdateReqDto.getClaimDate());

        insurancePolicy.setClaim(claim);

        insuranceRepository.save(insurancePolicy);

        return "claim updated successfully....";
    }
}
