package com.demospring.linktacker.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Link {
    private static int idCounter = 1;
    private int id;
    private String url;
    private String password;

    public Link(String url, String password) {
        this.id = idCounter;
        this.url = url;
        this.password = password;
        idCounter++;
    }
}
