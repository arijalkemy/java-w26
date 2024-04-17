package com.mercadolibre.covid19.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;
}
