package com.demospring.linktacker.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class LinkIdDTO implements Serializable {
    private int id;
    private String password;

    public LinkIdDTO(int id, String password) {
        this.id = id;
        this.password = password;
    }
}
