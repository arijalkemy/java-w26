package org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehiculo {

    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;

}
