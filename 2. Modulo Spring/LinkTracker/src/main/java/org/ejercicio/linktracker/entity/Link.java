package org.ejercicio.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
public class Link {
    private UUID id;
    private String link;
    private String password;
    private Integer viewers;

    public Link(String link, String password) {
        this.id = UUID.randomUUID();
        this.link = link;
        this.password = password;
        this.viewers = 0;
    }
}
