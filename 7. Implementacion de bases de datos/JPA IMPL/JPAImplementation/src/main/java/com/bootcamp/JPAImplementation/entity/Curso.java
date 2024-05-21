package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cursos")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String name;
    @ManyToOne
    @JoinColumn(name="docente_id", nullable = false)
    private Docente docente;
    @OneToMany(mappedBy = "curso")
    private List<Mentor> mentores;
    @ManyToMany
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Student> estudiantes;

}
