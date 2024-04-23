package com.demospring.linktacker.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class LinkRequestDTO implements Serializable {
    private String uri;

    public LinkRequestDTO() {
    }

    public LinkRequestDTO(String uri) {
        this.uri = uri;
    }
}
