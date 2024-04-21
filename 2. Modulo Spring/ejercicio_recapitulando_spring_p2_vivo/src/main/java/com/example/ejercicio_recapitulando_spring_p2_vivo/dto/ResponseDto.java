package com.example.ejercicio_recapitulando_spring_p2_vivo.dto;

public class ResponseDto {
    private String message;
    public ResponseDto() {}

    public ResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
