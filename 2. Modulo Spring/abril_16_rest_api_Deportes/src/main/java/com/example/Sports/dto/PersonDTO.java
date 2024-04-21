package com.example.Sports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PersonDTO implements Serializable {
    private String name;
    private String lastName;
    private String sportName;
}
