package com.meli.crudjpa.model.DTO;

import lombok.Data;

@Data
public class JoyaDTO {
    int nro_identificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    boolean posee_joya;
    boolean ventaONo;
}
