package com.Ejercicio.Covid.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private int levelOfSeverity;
}
