package org.bootcamp.showroom.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clothe_type")
public class ClotheType {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
