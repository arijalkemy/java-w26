package org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface SiniestroProjection {
    public Long getId_siniestro();
    public LocalDate getFecha_siniestro();
    public Double getPerdida_economica();
}
