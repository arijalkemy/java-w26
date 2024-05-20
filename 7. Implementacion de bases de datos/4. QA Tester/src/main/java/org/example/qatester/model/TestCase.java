package org.example.qatester.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUdate;
}
