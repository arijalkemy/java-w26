package com.meli.EjercicioDeportistas.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class SportPersonDTO implements Serializable {
    private String personName;
    private String personLastName;
    private String sportName;

    public SportPersonDTO(String personName, String personLastName, String sportName) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.sportName = sportName;
    }
}
