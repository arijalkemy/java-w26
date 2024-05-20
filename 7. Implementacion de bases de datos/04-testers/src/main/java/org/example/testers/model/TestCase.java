package org.example.testers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    @JsonProperty("id_case")
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDate lastUdate;
}
