package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false),
            @JoinColumn(name = "curso_id", referencedColumnName = "curso_id", nullable = false)
    })
    private StudentsCursos studentCurso;

    private Double nota;
}
