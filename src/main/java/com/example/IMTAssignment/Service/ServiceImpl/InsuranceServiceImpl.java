package com.example.IMTAssignment.Service.ServiceImpl;

import com.example.IMTAssignment.DTOs.InsurancePolicyDto;
import com.example.IMTAssignment.DTOs.InsurancePolicyUpdateReqDto;
import com.example.IMTAssignment.DTOs.InsuranceResponse.ClientResponseForInsuranceDto;
import com.example.IMTAssignment.DTOs.InsuranceResponse.InsurancePolicyResponseDto;
import com.example.IMTAssignment.Models.Client;
import com.example.IMTAssignment.Models.InsurancePolicy;
import com.example.IMTAssignment.Repository.ClientRepository;
import com.example.IMTAssignment.Repository.InsuranceRepository;
import com.example.IMTAssignment.Service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public String addInsurancePolicy(InsurancePolicyDto insurancePolicyDto) throws Exception {
        InsurancePolicy insurancePolicy=new InsurancePolicy();


        Client client=clientRepository.findByName(insurancePolicyDto.getClientName());

        insurancePolicy.setPolicyNumber(insurancePolicyDto.getPolicyNumber());
        insurancePolicy.setType(insurancePolicyDto.getInsuranceType());
        insurancePolicy.setCoverageAmount(insurancePolicyDto.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyDto.getPremium());
        insurancePolicy.setStartDate(insurancePolicyDto.getStartDate());
        insurancePolicy.setEndDate(insurancePolicyDto.getEndDate());
        insurancePolicy.setClient(client);

        client.setInsurancePolicy(insurancePolicy);

        clientRepository.save(client);

        return "insurance policy added successfully...";
    }

    @Override
    public InsurancePolicyResponseDto getInsurance(Integer id) throws Exception {

        InsurancePolicy insurancePolicy=insuranceRepository.findById(id).get();

        InsurancePolicyResponseDto insurancePolicyResponseDto=new InsurancePolicyResponseDto();

        ClientResponseForInsuranceDto clientResponseForInsuranceDto=new ClientResponseForInsuranceDto();

        clientResponseForInsuranceDto.setName(insurancePolicy.getClient().getName());
        clientResponseForInsuranceDto.setDateOfBirth(insurancePolicy.getClient().getBirthDate());
        clientResponseForInsuranceDto.setAddress(insurancePolicy.getClient().getAddress());
        clientResponseForInsuranceDto.setContact(insurancePolicy.getClient().getContact());

        insurancePolicyResponseDto.setPolicyNumber(insurancePolicy.getPolicyNumber());
        insurancePolicyResponseDto.setInsuranceType(insurancePolicy.getType());
        insurancePolicyResponseDto.setCoverageAmount(insurancePolicy.getCoverageAmount());
        insurancePolicyResponseDto.setPremium(insurancePolicy.getPremium());
        insurancePolicyResponseDto.setStartDate(insurancePolicy.getStartDate());
        insurancePolicyResponseDto.setEndDate(insurancePolicy.getEndDate());
        insurancePolicyResponseDto.setClient(clientResponseForInsuranceDto);

        return insurancePolicyResponseDto;
    }

    @Override
    public List<InsurancePolicyResponseDto> getAllInsurancePolicies() throws Exception {
        List<InsurancePolicy> insurancePolicyList=insuranceRepository.findAll();

        List<InsurancePolicyResponseDto> insurancePolicyResponseDtoList=new ArrayList<>();

        for(InsurancePolicy insurancePolicy:insurancePolicyList){
            InsurancePolicyResponseDto insurancePolicyResponseDto=new InsurancePolicyResponseDto();

            ClientResponseForInsuranceDto clientResponseForInsuranceDto=new ClientResponseForInsuranceDto();

            clientResponseForInsuranceDto.setName(insurancePolicy.getClient().getName());
            clientResponseForInsuranceDto.setDateOfBirth(insurancePolicy.getClient().getBirthDate());
            clientResponseForInsuranceDto.setAddress(insurancePolicy.getClient().getAddress());
            clientResponseForInsuranceDto.setContact(insurancePolicy.getClient().getContact());

            insurancePolicyResponseDto.setPolicyNumber(insurancePolicy.getPolicyNumber());
            insurancePolicyResponseDto.setInsuranceType(insurancePolicy.getType());
            insurancePolicyResponseDto.setCoverageAmount(insurancePolicy.getCoverageAmount());
            insurancePolicyResponseDto.setPremium(insurancePolicy.getPremium());
            insurancePolicyResponseDto.setStartDate(insurancePolicy.getStartDate());
            insurancePolicyResponseDto.setEndDate(insurancePolicy.getEndDate());
            insurancePolicyResponseDto.setClient(clientResponseForInsuranceDto);

            insurancePolicyResponseDtoList.add(insurancePolicyResponseDto);
        }
        return insurancePolicyResponseDtoList;
    }

    @Override
    public String deletePolicy(Integer id) throws Exception {
        InsurancePolicy insurancePolicy=insuranceRepository.findById(id).get();

        insuranceRepository.delete(insurancePolicy);

        return "policy has been deleted successfully...";
    }

    @Override
    public String updatePolicy(Integer id, InsurancePolicyUpdateReqDto insurancePolicyUpdateReqDto) throws Exception {
        InsurancePolicy insurancePolicy=insuranceRepository.findById(id).get();

        int clientId=insurancePolicy.getClient().getId();

        Client client=clientRepository.findById(clientId).get();

        insurancePolicy.setType(insurancePolicyUpdateReqDto.getInsuranceType());
        insurancePolicy.setCoverageAmount(insurancePolicyUpdateReqDto.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyUpdateReqDto.getPremium());
        insurancePolicy.setEndDate(insurancePolicyUpdateReqDto.getEndDate());

        client.setInsurancePolicy(insurancePolicy);

        clientRepository.save(client);

        return "client updated successfully.....";
    }


}
