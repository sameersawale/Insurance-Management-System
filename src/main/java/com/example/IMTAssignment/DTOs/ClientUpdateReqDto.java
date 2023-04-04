package com.example.IMTAssignment.DTOs;

public class ClientUpdateReqDto {

    private String address;

    private String contact;

    public ClientUpdateReqDto() {
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
