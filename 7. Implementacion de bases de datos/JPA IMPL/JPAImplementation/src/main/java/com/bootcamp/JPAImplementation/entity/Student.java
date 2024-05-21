package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@ToString
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identification;
    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursos;

    public Student (String identification, String name, String lastName) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
    }
}
