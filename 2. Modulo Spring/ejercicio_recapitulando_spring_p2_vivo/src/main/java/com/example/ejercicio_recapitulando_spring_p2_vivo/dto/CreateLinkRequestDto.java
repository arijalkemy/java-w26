package com.example.ejercicio_recapitulando_spring_p2_vivo.dto;

public class CreateLinkRequestDto {
    private String link;
    private String password;

    public CreateLinkRequestDto() {}

    public CreateLinkRequestDto(String link, String password) {
        this.link = link;
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
