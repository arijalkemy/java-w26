package com.EjercicioSpring.Ejercicio11_Excepciones.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDTO {

    LocalDate tiempo;
    String mensaje;
    String uri;

    public ErrorDTO(String mensaje, String uri) {
        tiempo = LocalDate.now();
        this.mensaje = mensaje;
        this.uri = uri.replace("uri=", "");
    }
}
