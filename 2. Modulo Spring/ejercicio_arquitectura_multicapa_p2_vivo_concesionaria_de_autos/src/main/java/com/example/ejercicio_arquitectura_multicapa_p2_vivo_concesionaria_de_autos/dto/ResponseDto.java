package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.dto;

public class ResponseDto {
    private String message;

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
