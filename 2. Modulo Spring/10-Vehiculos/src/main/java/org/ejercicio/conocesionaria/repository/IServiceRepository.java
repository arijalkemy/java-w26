package org.ejercicio.conocesionaria.repository;

import org.ejercicio.conocesionaria.entity.Service;
import org.ejercicio.conocesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IServiceRepository {
    Service findById(UUID id);
    Service save(Service vehicle);
    List<Service> findAll();
}
