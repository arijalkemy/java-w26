package com.example.deportista.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String nombre;
    private String apellido;
    private int edad;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "persona_deporte",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "deporte_id")
    )
    private Set<Deporte> deportes = new HashSet<>();

}
