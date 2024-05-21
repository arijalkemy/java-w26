package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "mentores")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nombre;
    private String apellido;
    private String mail;
}
