package com.mercadolibre.projectname.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO implements Serializable {
    private Long id;
    private String title;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
}
