package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Embedded
    private PersonData datosPersona;

    @ManyToMany
    @JoinTable(
            name = "mentor_curso",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Course> cursos;
}
