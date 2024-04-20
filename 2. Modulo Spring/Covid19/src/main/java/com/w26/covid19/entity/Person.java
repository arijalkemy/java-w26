package com.w26.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Person {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
}
