package com.link.link.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Link {
    private long id;
    private String urlRediccion;
    private Integer cantidadDeSolicitudes;
    private String password;
}
