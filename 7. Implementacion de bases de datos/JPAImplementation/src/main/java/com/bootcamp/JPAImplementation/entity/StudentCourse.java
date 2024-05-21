package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_course")
public class StudentCourse {
    @Id
    private Long id;
    @ManyToOne
    private Student idStudent;
    @ManyToOne
    private Course idCourse;
    private Double calificacionUno;
    private Double calificacionDos;
}
