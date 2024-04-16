package org.example.api.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private static Integer autoId = 0;
    private Integer id;
    private String name;
    private Integer levelSeverity;

    public Symptom(String name, Integer levelSeverity) {
        this.id = ++Symptom.autoId;
        this.name = name;
        this.levelSeverity = levelSeverity;
    }
}
