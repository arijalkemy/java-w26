package com.ejercicio.segurosdeautos.proyections;

public interface VehicleProjections {
    Long getId();
    String getPatent();
    String getBrand();
    String getModel();
    Integer getFebricationYear();
    Integer getWheels();
    Double getEconomicLost(); // Nuevo campo para la pérdida económica total
}