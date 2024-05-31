package com.example.ejercicios_dto_y_response_entityvivo_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DeportistDTO {
    private String name;
    private String lastname;
    @JsonProperty("name_sport")
    private String nameSport;
}
