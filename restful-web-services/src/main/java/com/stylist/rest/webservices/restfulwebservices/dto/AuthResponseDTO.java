package com.stylist.rest.webservices.restfulwebservices.dto;

public class AuthResponseDTO {
    private String jwtToken;

    public AuthResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public AuthResponseDTO() {
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
