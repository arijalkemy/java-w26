package org.meli.ejercicio6_p2_d2_qa_testers.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseDtoRequest {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
