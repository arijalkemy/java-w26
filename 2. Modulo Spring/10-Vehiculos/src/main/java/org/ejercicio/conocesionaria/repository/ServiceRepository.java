package org.ejercicio.conocesionaria.repository;

import org.ejercicio.conocesionaria.entity.Service;
import org.ejercicio.conocesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ServiceRepository implements IServiceRepository {

    Map<UUID, Service> services;

    public ServiceRepository() {
        this.services = new HashMap<>();
    }

    @Override
    public Service findById(UUID id) {
        return services.get(id);
    }

    @Override
    public Service save(Service service) {
        services.put(service.getId(), service);
        return service;
    }

    @Override
    public List<Service> findAll() {
        return services.values().stream().toList();
    }
}
