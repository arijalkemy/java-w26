package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.repository;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ServiceRepository implements IRepository<Service, Integer> {

    @Override
    public Service addElement(Service service) {
        Integer id = dataBase.getServices().size() + 1;
        service.setId(id);
        dataBase.addService(service, id);
        return service;
    }

    @Override
    public Map<Integer, Service> getAll() {
        return dataBase.getServices();
    }

    @Override
    public Service getById(Integer integer) {
        if (dataBase.getServices().containsKey(integer)) {
            return dataBase.getServices().get(integer);
        }
        return null;
    }

    @Override
    public List<Service> getAllByForeingId(Integer integer) {
        List<Service> services = new ArrayList<>();
        for (Service service : dataBase.getServices().values()) {
            if (service.getIdVehicle().equals(integer)) {
                services.add(service);
            }
        }
        return services;

    }
}
