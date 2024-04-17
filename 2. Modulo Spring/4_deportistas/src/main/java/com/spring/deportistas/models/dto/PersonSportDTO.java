package com.spring.deportistas.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonSportDTO implements Serializable {

    private String fullName;
    private String sportName;

    public PersonSportDTO(String fullName, String sportName) {
        this.fullName = fullName;
        this.sportName = sportName;
    }

}
