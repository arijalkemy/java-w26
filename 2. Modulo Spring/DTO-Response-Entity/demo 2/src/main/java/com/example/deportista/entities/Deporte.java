package com.example.deportista.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String nombre;
    private int nivel;


    @JsonBackReference
    @ManyToMany(mappedBy = "deportes")
    private Set<Persona> personas = new HashSet<>();


}
