package com.example.qatester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@JsonPropertyOrder({ "idCase", "description", "tested", "passed", "numberOfTries", "lastUpdate" })
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDate lastUpdate = LocalDate.now();
}
