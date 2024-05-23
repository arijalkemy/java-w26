package com.mercadolibre.testcases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TestCaseResponseDTO extends TestCaseDTO implements Serializable {
    private Long id;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
