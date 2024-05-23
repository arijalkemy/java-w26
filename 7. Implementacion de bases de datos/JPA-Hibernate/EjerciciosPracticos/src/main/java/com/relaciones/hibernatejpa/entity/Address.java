package com.relaciones.hibernatejpa.entity;

import jakarta.persistence.*;

// RELACION UNO A UNO
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
