package com.ejercicio.linktracker.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Link {
    private int id;
    private String url;
    private int visitsNumber;

    public Link(int id, String url) {
        this.id = id;
        this.url = url;
        this.visitsNumber = 0;
    }
}
