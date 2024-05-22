package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentCourseCalification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Double calification1;
    private Double calification2;
}
