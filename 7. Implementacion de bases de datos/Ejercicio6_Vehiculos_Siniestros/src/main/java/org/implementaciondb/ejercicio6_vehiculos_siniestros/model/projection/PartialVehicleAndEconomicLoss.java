package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection;

public interface PartialVehicleAndEconomicLoss {
    String getPatent();
    String getModel();
    String getBrand();
    Double getEconomicLoss();
}
