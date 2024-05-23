package com.relaciones.hibernatejpa.entity;

import com.relaciones.hibernatejpa.entity.Cart;
import jakarta.persistence.*;


@Entity
@Table (name = "items")
public class Items {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
