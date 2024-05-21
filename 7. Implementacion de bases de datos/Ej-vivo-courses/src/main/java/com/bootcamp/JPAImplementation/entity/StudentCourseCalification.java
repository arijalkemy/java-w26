package com.bootcamp.JPAImplementation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseCalification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    private Double calification1;
    private Double calification2;

    public StudentCourseCalification(Course course, Student student, Double calification1, Double calification2) {
        this.course = course;
        this.student = student;
        this.calification1 = calification1;
        this.calification2 = calification2;
    }
}
