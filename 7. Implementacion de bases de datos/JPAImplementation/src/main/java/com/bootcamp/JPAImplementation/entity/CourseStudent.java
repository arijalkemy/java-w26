package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @ElementCollection
    private List<Double> notes;
}
