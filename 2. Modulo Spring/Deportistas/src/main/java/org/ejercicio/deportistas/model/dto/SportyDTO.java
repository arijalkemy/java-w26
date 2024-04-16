package org.ejercicio.deportistas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SportyDTO implements Serializable {
    private String name;
    private String lastName;
    private String sportName;
}
