package com.opcionalClaveCompuesta.opcionalClaveCompuesta.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany( mappedBy = "likedCourses")
    Set<Student> students;
}
