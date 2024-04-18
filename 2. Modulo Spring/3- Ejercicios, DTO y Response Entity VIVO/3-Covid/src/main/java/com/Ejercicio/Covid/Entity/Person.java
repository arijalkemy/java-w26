package com.Ejercicio.Covid.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String surname;
    private Integer age;
    private Symptom symptom;
}
