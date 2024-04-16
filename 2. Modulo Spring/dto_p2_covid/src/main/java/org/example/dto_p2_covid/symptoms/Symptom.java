package org.example.dto_p2_covid.symptoms;

public class Symptom {
    private int code;
    private String name;
    private String level;

    public Symptom(int code, String name, String level) {
        this.code = code;
        this.name = name;
        this.level = level;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
