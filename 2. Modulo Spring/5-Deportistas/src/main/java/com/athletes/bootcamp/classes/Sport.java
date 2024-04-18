package com.athletes.bootcamp.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Sport {
    private String name;
    private Integer level;
}
