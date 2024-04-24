package com.autos.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO implements Serializable {
    private Integer id;
    private String marca;
    private String modelo;
    private LocalDate fechaManufactura;
    private Integer kilometros;
    private Integer puertas;
    private Integer precio;
    private String divisa;
    private Integer cantidadPropietarios;
}
