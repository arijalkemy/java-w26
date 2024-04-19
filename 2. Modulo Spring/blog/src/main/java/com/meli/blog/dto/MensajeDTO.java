package com.meli.blog.dto;

import lombok.Data;

@Data
public class MensajeDTO {
    private String mensaje;

    public MensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}
