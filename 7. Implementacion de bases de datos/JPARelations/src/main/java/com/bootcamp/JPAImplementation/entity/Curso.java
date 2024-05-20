package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToMany
    @JoinTable(
            name = "curso_mentores",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private List<Mentor> mentores;

    @OneToMany(mappedBy = "curso")
    private Set<CursoEstudiante> curso;
}
