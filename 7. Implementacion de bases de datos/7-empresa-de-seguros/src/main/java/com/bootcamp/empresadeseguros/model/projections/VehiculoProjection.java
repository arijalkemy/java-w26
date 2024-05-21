package com.bootcamp.empresadeseguros.model.projections;

import jakarta.persistence.Column;

public interface VehiculoProjection {
    String getPatente();
    String getMarca();
    String getModelo();
}
