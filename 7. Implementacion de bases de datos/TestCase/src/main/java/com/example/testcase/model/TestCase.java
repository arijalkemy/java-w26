package com.example.testcase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;

}
