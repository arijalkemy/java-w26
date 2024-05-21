package com.opcionalClaveCompuesta.opcionalClaveCompuesta.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn( name = "student_id"),
            inverseJoinColumns = @JoinColumn( name = "course_id"))
    Set<Course> likedCourses;
}
