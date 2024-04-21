package org.example.ejercicio_covid.models;

public class Symptom {
    private Long code;
    private String name;
    private String levelOfSeverity;

    public Symptom(Long code, String name, String levelOfSeverity) {
        this.code = code;
        this.name = name;
        this.levelOfSeverity = levelOfSeverity;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelOfSeverity() {
        return levelOfSeverity;
    }

    public void setLevelOfSeverity(String levelOfSeverity) {
        this.levelOfSeverity = levelOfSeverity;
    }
}
