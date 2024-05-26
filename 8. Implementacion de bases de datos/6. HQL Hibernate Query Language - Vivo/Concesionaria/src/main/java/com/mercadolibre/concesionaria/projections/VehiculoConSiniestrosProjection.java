package com.mercadolibre.concesionaria.projections;

import com.mercadolibre.concesionaria.model.Siniestro;

import java.util.List;

public interface VehiculoConSiniestrosProjection {
    String getPatente();
    String getMarca();
    String getModelo();
    List<Siniestro> getSiniestros();
}
