package com.EjercicioSpring.Ejercicio13_LinkTracker.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDTO implements Serializable {

    LocalDate tiempo;
    String mensaje;
    String uri;

    public ErrorDTO(String mensaje, String uri) {
        tiempo = LocalDate.now();
        this.mensaje = mensaje;
        this.uri = uri.replace("uri=", "");
    }

}
