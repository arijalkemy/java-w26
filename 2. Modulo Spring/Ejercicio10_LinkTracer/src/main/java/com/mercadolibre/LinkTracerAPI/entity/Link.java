package com.mercadolibre.LinkTracerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {
    private Integer id;
    private String Url;
    private String redireccion;
    private Integer cantRedireccion;
    private String contraseña;
    private boolean valido;
}
