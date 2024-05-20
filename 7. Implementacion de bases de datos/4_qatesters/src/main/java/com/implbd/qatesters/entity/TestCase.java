package com.implbd.qatesters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "testcases")
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    private Long idCase;

    private String description;
    private Boolean tested;
    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
