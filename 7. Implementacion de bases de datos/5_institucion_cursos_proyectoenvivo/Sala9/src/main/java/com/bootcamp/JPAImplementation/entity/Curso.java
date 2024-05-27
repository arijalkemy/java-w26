package com.bootcamp.JPAImplementation.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
    @ManyToMany
    @JoinTable(
            name = "mentores_cursos",
            joinColumns = @JoinColumn(name = "id_mentor"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Mentor> mentores;
    @ManyToMany
    @JoinTable(
            name = "estudiantes_cursos",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_cursos")
    )
    private Set<Student> estudiantesInscritos;

}
