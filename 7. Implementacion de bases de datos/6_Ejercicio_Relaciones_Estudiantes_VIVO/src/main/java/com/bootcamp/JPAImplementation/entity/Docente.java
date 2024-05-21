package com.bootcamp.JPAImplementation.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nombre;
    private String apellido;
    private String mail;
    @OneToMany(mappedBy = "docente")
    private Set<Curso> cursos;
}
