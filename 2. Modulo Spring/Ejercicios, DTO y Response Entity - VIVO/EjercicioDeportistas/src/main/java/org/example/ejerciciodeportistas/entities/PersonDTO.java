package org.example.ejerciciodeportistas.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {
    private String name;
    private String lastName;
    private String sportName;
}
