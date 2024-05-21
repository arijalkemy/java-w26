package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentsByCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private long student_id;
    private long course_id;

    private double qualification1;
    private double qualification2;

    private double average;
}
