package com.example.IMTAssignment.Service.ServiceImpl;

import com.example.IMTAssignment.DTOs.ClientDto;
import com.example.IMTAssignment.DTOs.ClientResponse.ClientResponseDto;
import com.example.IMTAssignment.DTOs.ClientResponse.InsuranceResponseForClientDto;
import com.example.IMTAssignment.DTOs.ClientUpdateReqDto;
import com.example.IMTAssignment.Models.Client;
import com.example.IMTAssignment.Repository.ClientRepository;
import com.example.IMTAssignment.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public String addClient(ClientDto clientDto) throws Exception{
        Client client=new Client();
        client.setName(clientDto.getName());
        client.setBirthDate(clientDto.getDateOfBirth());
        client.setAddress(clientDto.getAddress());
        client.setContact(clientDto.getContact());

        clientRepository.save(client);

        return "client added successfully...";
    }

    @Override
    public ClientResponseDto getClient(Integer id) throws Exception {

        Client client=clientRepository.findById(id).get();

        ClientResponseDto clientResponseDto=new ClientResponseDto();

        InsuranceResponseForClientDto insuranceResponseForClientDto=new InsuranceResponseForClientDto();

        insuranceResponseForClientDto.setNumber(client.getInsurancePolicy().getPolicyNumber());
        insuranceResponseForClientDto.setInsuranceType(client.getInsurancePolicy().getType());
        insuranceResponseForClientDto.setCoverageAmount(client.getInsurancePolicy().getCoverageAmount());
        insuranceResponseForClientDto.setPremium(client.getInsurancePolicy().getPremium());
        insuranceResponseForClientDto.setStartDate(client.getInsurancePolicy().getStartDate());
        insuranceResponseForClientDto.setEndDate(client.getInsurancePolicy().getEndDate());

        clientResponseDto.setName(client.getName());
        clientResponseDto.setDateOfBirth(client.getBirthDate());
        clientResponseDto.setAddress(client.getAddress());
        clientResponseDto.setContact(client.getContact());
        clientResponseDto.setInsurancePolicy(insuranceResponseForClientDto);

        return clientResponseDto;


    }

    @Override
    public List<ClientResponseDto> getAllClient() throws Exception {
        List<Client> clientList=clientRepository.findAll();

        List<ClientResponseDto> clientResponseDtoList=new ArrayList<>();

        for(Client client:clientList){
            ClientResponseDto clientResponseDto=new ClientResponseDto();

            InsuranceResponseForClientDto insuranceResponseForClientDto=new InsuranceResponseForClientDto();

            insuranceResponseForClientDto.setNumber(client.getInsurancePolicy().getPolicyNumber());
            insuranceResponseForClientDto.setInsuranceType(client.getInsurancePolicy().getType());
            insuranceResponseForClientDto.setCoverageAmount(client.getInsurancePolicy().getCoverageAmount());
            insuranceResponseForClientDto.setPremium(client.getInsurancePolicy().getPremium());
            insuranceResponseForClientDto.setStartDate(client.getInsurancePolicy().getStartDate());
            insuranceResponseForClientDto.setEndDate(client.getInsurancePolicy().getEndDate());

            clientResponseDto.setName(client.getName());
            clientResponseDto.setDateOfBirth(client.getBirthDate());
            clientResponseDto.setAddress(client.getAddress());
            clientResponseDto.setContact(client.getContact());
            clientResponseDto.setInsurancePolicy(insuranceResponseForClientDto);

            clientResponseDtoList.add(clientResponseDto);
        }
        return clientResponseDtoList;
    }

    @Override
    public String deleteClient(Integer id) throws Exception {
        clientRepository.deleteById(id);
        return "client deleted successfully...";
    }

    @Override
    public String updateClient(Integer id, ClientUpdateReqDto clientUpdateReqDto) throws Exception {
        Client client=clientRepository.findById(id).get();

        client.setAddress(clientUpdateReqDto.getAddress());
        client.setContact(clientUpdateReqDto.getContact());

        clientRepository.save(client);

        return "client update successfully....";
    }
}
