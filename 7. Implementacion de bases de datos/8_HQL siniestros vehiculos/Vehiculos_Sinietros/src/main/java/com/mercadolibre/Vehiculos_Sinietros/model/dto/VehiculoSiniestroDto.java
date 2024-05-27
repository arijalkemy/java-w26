package com.mercadolibre.Vehiculos_Sinietros.model.dto;

import com.mercadolibre.Vehiculos_Sinietros.model.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDto {
    private HashMap<Vehiculo,Integer> siniestroVehiculo;
}
