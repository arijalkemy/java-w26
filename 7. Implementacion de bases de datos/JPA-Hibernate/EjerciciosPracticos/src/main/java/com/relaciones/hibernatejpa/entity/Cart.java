package com.relaciones.hibernatejpa.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "cart")
    private Set<Items> items;
}
