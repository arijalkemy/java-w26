package com.implementaciondb.ejercicio9_obras_literarias.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaRequestDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("number_pages")
    private Integer numberPages;

    @JsonProperty("editoria")
    private String editoria;

    @JsonProperty("year_publication")
    private Integer yearPublication;

}
