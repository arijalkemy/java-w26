package com.mercadolibre.LinkTracerAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkDTO {
    private Integer id;
    private String Url;
    private String redireccion;
    private Integer cantRedireccion;
    private String contraseña;
    private boolean valido;
}
