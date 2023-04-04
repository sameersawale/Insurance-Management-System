package com.example.IMTAssignment.Controller;

import com.example.IMTAssignment.DTOs.ClaimDto;
import com.example.IMTAssignment.DTOs.ClaimResponse.ClaimResponseDto;
import com.example.IMTAssignment.DTOs.ClaimUpdateReqDto;
import com.example.IMTAssignment.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity addClaim(@RequestBody ClaimDto claimDto){
        try {
            String result = claimService.addClaim(claimDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result="claim request denied!!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity getClaimById(@PathVariable("id") Integer id){
        try {
                ClaimResponseDto claimResponseDto=claimService.getClaimById(id);
                return new ResponseEntity<>(claimResponseDto, HttpStatus.FOUND);
            }
        catch (Exception e){
            String result="please check claim id!!!";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity getAllClaims(){
        try{
            List<ClaimResponseDto>claimResponseDtoList=claimService.getAllClaims();
            return new ResponseEntity<>(claimResponseDtoList, HttpStatus.FOUND);
        }
        catch (Exception e){
            String result="claim list not found!!!!";
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity deleteClaim(@PathVariable("id")Integer id){
        try {
            String result= claimService.deleteClaim(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="error occurred while deleting claim";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or ('ROLE_ADMIN')")
    public ResponseEntity updateClaim(@PathVariable("id")Integer id, ClaimUpdateReqDto claimUpdateReqDto){
        try {
            String result= claimService.updateClaim(id, claimUpdateReqDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            String result="error occurred while updating claim!!!! ";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

}
