package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.dto;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import lombok.Data;

@Data
public class PersonDTO {

    private String name;
    private String lastName;
    private Sport sport;
}
