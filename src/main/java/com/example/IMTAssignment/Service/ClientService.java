package com.example.IMTAssignment.Service;

import com.example.IMTAssignment.DTOs.ClientDto;
import com.example.IMTAssignment.DTOs.ClientResponse.ClientResponseDto;
import com.example.IMTAssignment.DTOs.ClientUpdateReqDto;

import java.util.List;

public interface ClientService {

    public abstract String addClient(ClientDto  clientDto) throws Exception;

    public abstract ClientResponseDto getClient(Integer id) throws Exception;

    public abstract List<ClientResponseDto> getAllClient() throws Exception;

    public abstract String deleteClient(Integer id) throws Exception;

    public abstract String updateClient(Integer id, ClientUpdateReqDto clientUpdateReqDto) throws Exception;


}
