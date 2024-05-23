package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
    private Double grade1;
    private Double grade2;
    private Double average;

    public CourseGrade(Course course, Student student, Double grade1, Double grade2) {
        this.course = course;
        this.student = student;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.average = (grade1 + grade2) / 2;
    }
}
