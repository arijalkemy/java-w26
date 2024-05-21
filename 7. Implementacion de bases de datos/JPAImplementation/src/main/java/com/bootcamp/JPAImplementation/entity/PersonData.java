package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonData {
    private String nombre;
    private String apellido;
    private String email;
}
