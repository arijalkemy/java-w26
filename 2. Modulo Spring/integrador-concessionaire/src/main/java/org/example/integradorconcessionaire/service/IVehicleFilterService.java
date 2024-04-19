package org.example.integradorconcessionaire.service;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleFilterService <K>{
    public List<K> getByDateRange(LocalDate start, LocalDate end);
    public List<K> getByPriceRange(double min, double max);
}
