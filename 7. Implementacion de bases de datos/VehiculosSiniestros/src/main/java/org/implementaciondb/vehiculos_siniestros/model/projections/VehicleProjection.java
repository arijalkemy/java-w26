package org.implementaciondb.vehiculos_siniestros.model.projections;

public interface VehicleProjection {
    String getPatent();
    String getBrand();
    String getModel();
    Double getEconomicLoss();
}
