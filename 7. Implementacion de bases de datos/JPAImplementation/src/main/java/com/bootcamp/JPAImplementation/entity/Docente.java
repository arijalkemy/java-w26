package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nombre;
    private String apellido;
    private String cargo;
    @ManyToMany(mappedBy = "ayudantes")
    Set<Curso> cursos;
}
