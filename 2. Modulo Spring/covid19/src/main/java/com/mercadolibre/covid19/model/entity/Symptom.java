package com.mercadolibre.covid19.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private Integer code;
    private String name;
    private String severity;

}
