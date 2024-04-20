package com.w26.covid19.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {

    public enum SEVERITY{
        LOW(1),
        MEDIUM(2),
        HIGHT(3);
        private int value;
        private SEVERITY(int value){
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }
    }

    private String code;
    private String name;
    private int severity;

    public Symptom(String name, SEVERITY severity)
    {
        this.code = UUID.randomUUID().toString();
        this.name = name;
        this.severity = severity.getValue();
    }
}
