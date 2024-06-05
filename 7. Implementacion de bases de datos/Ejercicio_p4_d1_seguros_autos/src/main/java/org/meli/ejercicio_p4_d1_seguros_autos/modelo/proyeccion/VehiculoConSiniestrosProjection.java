package org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion;

import java.util.Set;

public interface VehiculoConSiniestrosProjection {
    String getMatricula();
    String getPatente();
    String getMarca();
    String getModelo();
    Integer getAgnoFabricacion();
    Integer getNumRuedas();
    Set<SiniestroProjection> getSiniestros();
}
