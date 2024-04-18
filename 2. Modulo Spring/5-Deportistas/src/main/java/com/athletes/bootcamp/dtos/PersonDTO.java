package com.athletes.bootcamp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class PersonDTO implements Serializable {
    private String personName;
    private String personSurname;
    private String sportName;
}
