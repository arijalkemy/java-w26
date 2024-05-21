package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estudiante_curso")
public class CursoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name="curso_id", nullable = false)
    private Curso curso;
    private Float nota1;
    private Float nota2;
}
