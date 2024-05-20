package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Mentor {

    @Id
    private Long id;

    private String nombre;
    private String apellido;

    @ManyToMany(mappedBy = "mentores")
    private List<Curso> cursos;

}
