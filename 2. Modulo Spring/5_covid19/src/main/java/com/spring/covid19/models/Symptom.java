package com.spring.covid19.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {

    private String code;
    private String name;
    private Integer risklevel;

    public Symptom(String code, String name, Integer risklevel) {
        this.code = code;
        this.name = name;
        this.risklevel = risklevel;
    }

}
