package com.implementaciondb.ejercicio9_obras_literarias.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("number_pages")
    private Integer numberPages;

    @JsonProperty("editoria")
    private String editorial;

    @JsonProperty("year_publication")
    private Integer yearPublication;
}