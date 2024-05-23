package com.relaciones.hibernatejpa.entity;

import com.relaciones.hibernatejpa.entity.Address;
import jakarta.persistence.*;

// RELACION UNO A UNO
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
