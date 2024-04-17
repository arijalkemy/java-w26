package com.ej1p2.covid19.model;

public class Symptom {
    private int code;
    private String name;
    private String severityLevel;

    public Symptom() {
    }

    public Symptom(int code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public int getCode() {
        return code;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public String getName() {
        return name;
    }
}
