package com.example.ejercicio_recapitulando_spring_p2_vivo.dto;

public class CreateLinkResponseDto {
    private String linkId;
    private String password;

    public CreateLinkResponseDto() {}

    public CreateLinkResponseDto(String linkId, String password) {
        this.linkId = linkId;
        this.password = password;
    }

    public String getLink() {
        return linkId;
    }

    public void setLink(String linkId) {
        this.linkId = linkId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
