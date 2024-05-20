package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curso_estudiantes")
public class CursoEstudiante {

    @Id
    private Long id;

    private Integer calificacion;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
