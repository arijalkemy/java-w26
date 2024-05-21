package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Embedded
    private PersonData datosPersona;
}
