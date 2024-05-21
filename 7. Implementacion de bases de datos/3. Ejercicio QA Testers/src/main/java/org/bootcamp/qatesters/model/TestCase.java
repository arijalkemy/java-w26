package org.bootcamp.qatesters.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_cases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    Integer numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
