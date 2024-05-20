package com.example.manualtester.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;

    public TestCase(String description, Boolean tested, Boolean passed, Integer number_of_tries, LocalDate last_update) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }
}
