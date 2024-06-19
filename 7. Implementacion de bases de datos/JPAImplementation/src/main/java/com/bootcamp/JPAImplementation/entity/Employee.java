package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Long identification;
    private String email;
}
