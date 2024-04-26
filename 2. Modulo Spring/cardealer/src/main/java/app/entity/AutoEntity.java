package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AutoEntity {
     UUID id;
     String marca;
     String modelo;
     String matricula;
     String color;
     Date anioFabricacion;
     Integer maxVel;
     Integer capacidadPersonas;
     String tipoCombustible;
     String tipoTransmicion;
     Double largo;
     Double ancho;
     Double peso;
}
