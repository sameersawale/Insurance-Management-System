package com.example.IMTAssignment.Controller;

import com.example.IMTAssignment.DTOs.InsurancePolicyDto;
import com.example.IMTAssignment.DTOs.InsurancePolicyUpdateReqDto;
import com.example.IMTAssignment.DTOs.InsuranceResponse.InsurancePolicyResponseDto;
import com.example.IMTAssignment.Service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsurancePolicyController {


    @Autowired
    InsuranceService insuranceService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity addInsurancePolicy(@RequestBody InsurancePolicyDto insurancePolicyDto){
        try{
            String result= insuranceService.addInsurancePolicy(insurancePolicyDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result="insurance policy not added check your details carefully before add!!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity getInsurancePolicy(@PathVariable("id")Integer id){
        try {
            InsurancePolicyResponseDto insurancePolicyResponseDto=insuranceService.getInsurance(id);
            return new ResponseEntity<>(insurancePolicyResponseDto, HttpStatus.FOUND);
        }
        catch (Exception e){
            String result="Insurance Policy id is invalid!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity getAllInsurancePolicies(){
        try {
            List<InsurancePolicyResponseDto> insurancePolicyResponseDtoList=insuranceService.getAllInsurancePolicies();
            return new ResponseEntity<>(insurancePolicyResponseDtoList, HttpStatus.FOUND);
        }
        catch (Exception e){
            String result="Insurance policies list not found!!!!";
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity deletePolicy(@PathVariable("id")Integer id){
        try {
            String result= insuranceService.deletePolicy(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="Error occurred while deleting policy";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity updatePolicy(@PathVariable("id")Integer id, @RequestBody InsurancePolicyUpdateReqDto insurancePolicyUpdateReqDto){
        try {
            String result=insuranceService.updatePolicy(id, insurancePolicyUpdateReqDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="error occurred while updating insurance policy!!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }


    }
}
