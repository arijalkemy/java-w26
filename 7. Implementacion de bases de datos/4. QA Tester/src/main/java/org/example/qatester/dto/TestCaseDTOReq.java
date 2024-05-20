package org.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class TestCaseDTOReq {
    @JsonProperty("id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUdate;
}
