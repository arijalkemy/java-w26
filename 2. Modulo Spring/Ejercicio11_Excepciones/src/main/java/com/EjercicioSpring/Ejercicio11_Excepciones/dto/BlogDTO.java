package com.EjercicioSpring.Ejercicio11_Excepciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogDTO implements Serializable {
    @JsonProperty("id")
    Long id;

    @JsonProperty("titulo")
    String titulo;

    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("fechaPublicacion")
    LocalDate fechaPublicacion;

    public BlogDTO(Long id, String titulo, String nombre, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }

    public BlogDTO() {
    }
}
