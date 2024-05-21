package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Teacher docente;

    @ManyToMany(mappedBy = "cursos")
    private List<Mentor> mentores;

    @OneToMany
    @JoinColumn(name = "course_id")
    private List<StudentsByCourses> studentsByCourses;
}
