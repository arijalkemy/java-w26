package com.mercadolibre.Vehiculos_Sinietros.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;


@Data
@AllArgsConstructor
public class VehiculoSiniestro {
    private HashMap<Vehiculo,Integer> siniestroVehiculo;
}
