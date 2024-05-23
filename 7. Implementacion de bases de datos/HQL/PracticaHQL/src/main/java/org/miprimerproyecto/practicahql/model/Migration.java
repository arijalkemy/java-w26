package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "migrations")
@Data
public class Migration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "migration")
    private String migration;
    @Column(name = "batch")
    private Integer batch;
// Getters and setters
}