package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Entity
@Data
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")
    private List<Course> courses;
    @ManyToMany(mappedBy = "mentors")
    private Set<Course> coursesMentored;
}
