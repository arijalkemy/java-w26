package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String courseName;
    @ManyToOne
    private Employee teacher;
    @ManyToMany
    @JoinTable(
            name = "Course_Mentor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private List<Employee> mentorList;
}
