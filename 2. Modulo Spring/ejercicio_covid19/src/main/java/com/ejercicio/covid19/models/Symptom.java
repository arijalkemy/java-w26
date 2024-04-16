package com.ejercicio.covid19.models;

public class Symptom {
    private String code;
    private String name;
    private String gravityLevel;

    public Symptom(String code, String name, String gravityLevel) {
        this.code = code;
        this.name = name;
        this.gravityLevel = gravityLevel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGravityLevel() {
        return gravityLevel;
    }

    public void setGravityLevel(String gravityLevel) {
        this.gravityLevel = gravityLevel;
    }
}
