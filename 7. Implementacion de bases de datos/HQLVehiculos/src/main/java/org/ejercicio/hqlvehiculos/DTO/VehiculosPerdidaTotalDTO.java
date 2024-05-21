package org.ejercicio.hqlvehiculos.DTO;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VehiculosPerdidaTotalDTO {
    List<VehiculoDTO> vehiculos;
    Double total;
}
