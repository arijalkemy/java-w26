package org.implementaciondb.ejercicio3_qatesters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_cases")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "tested", nullable = false)
    private Boolean tested;

    @Column(name = "passed", nullable = false)
    private Boolean passed;

    @Column(name = "number_of_tries", nullable = false)
    private Integer numberOfTries;

    @Column(name = "last_update", columnDefinition = "DATE")
    private LocalDate lastUpdate;

}

