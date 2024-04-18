package com.EjercicioSpring.Ejercicio11_Excepciones.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Entity
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class Blog {

    @Id
    @JsonProperty("id")
    Long id;

    @JsonProperty("titulo")
    String titulo;

    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("fechaPublicacion")
    LocalDate fechaPublicacion;

    public Blog() {
    }

    public Blog(Long id, String titulo, String nombre, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }
}
