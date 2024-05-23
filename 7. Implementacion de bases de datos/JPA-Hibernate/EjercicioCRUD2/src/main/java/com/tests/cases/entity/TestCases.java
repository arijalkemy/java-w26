package com.tests.cases.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tests")
public class TestCases {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_case;

    private String description;
    private boolean tested;
    private boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
