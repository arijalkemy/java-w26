package com.w26.seguros_autos.seguros_autos.mediator.projection;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleSiniestro 
{
    Long getId();
    LocalDate getFechaSiniestro();
    Double getPerdidaEconomica();
    SimpleVehiculo getVehiculo();

    @Value("#{target.vehiculo.patente}")
    String getSummaryVehiculo();
}

