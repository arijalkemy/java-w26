package com.ejercicio.testcases.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "testcases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idCase;

    private String description;
    private boolean tested;
    private boolean passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
