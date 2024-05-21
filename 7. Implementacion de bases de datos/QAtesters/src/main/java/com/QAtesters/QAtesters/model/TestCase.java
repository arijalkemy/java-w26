package com.QAtesters.QAtesters.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class TestCase {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    LocalDateTime last_update;
}
