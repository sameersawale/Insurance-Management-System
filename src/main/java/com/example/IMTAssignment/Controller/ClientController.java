package com.example.IMTAssignment.Controller;

import com.example.IMTAssignment.DTOs.ClientDto;
import com.example.IMTAssignment.DTOs.ClientResponse.ClientResponseDto;
import com.example.IMTAssignment.DTOs.ClientUpdateReqDto;
import com.example.IMTAssignment.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity addClient(@RequestBody ClientDto clientDto){
        try{
            String result= clientService.addClient(clientDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result="client not added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity getClient(@PathVariable("id") Integer id){
        try{
            ClientResponseDto clientResponseDto=clientService.getClient(id);
            return new ResponseEntity<>(clientResponseDto, HttpStatus.FOUND);
        }
        catch (Exception e){
            String result="please check client id!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity getAllClient(){
        try {
            List<ClientResponseDto> clientResponseDtoList=clientService.getAllClient();
            return new ResponseEntity<>(clientResponseDtoList, HttpStatus.FOUND);
        }
       catch (Exception e){
            String result="list of client not found!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
       }
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity deleteClient(@PathVariable("id")Integer id){
        try {
            String result= clientService.deleteClient(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="error occurred while deleting client!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity updateClient(@PathVariable("id")Integer id, @RequestBody ClientUpdateReqDto clientUpdateReqDto){
        try{
            String result= clientService.updateClient(id, clientUpdateReqDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="error occurred while updating client";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }

}
