package org.ejercicio.linktracker.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Link {
    private UUID id;
    private String link;
    private String password;
    private Integer redirections;

    public Link(String link, String password) {
        this.id = UUID.randomUUID();
        this.link = link;
        this.password = password;
        this.redirections = 0;
    }
}
