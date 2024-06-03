package com.javabootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private int Vistas;
    private String password;
    private Boolean valido;

}
