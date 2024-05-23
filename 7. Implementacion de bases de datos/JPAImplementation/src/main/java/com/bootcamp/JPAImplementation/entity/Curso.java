package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cursos")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docenteACargo;

    @ManyToMany
    @JoinTable(
        name = "cursos_mentores",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    private List<Docente> mentores;

    @ManyToMany(mappedBy = "cursos")
    private List<Student> estudiantes;

    public Curso(String nombre, Docente docenteACargo, List<Docente> mentores) {
        this.nombre = nombre;
        this.docenteACargo = docenteACargo;
        this.mentores = mentores;
    }
}
