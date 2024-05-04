package com.meli.ejercicioenvivovehiculo.repository.Impl;

import com.meli.ejercicioenvivovehiculo.model.Service;
import com.meli.ejercicioenvivovehiculo.model.Vehicule;
import com.meli.ejercicioenvivovehiculo.repository.IVehiculeRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Repository
public class VehiculeRepository implements IVehiculeRepository {

    static List<Vehicule> vehicules = new ArrayList<>();

    static
    {
        Random random = new Random();
        String[] services = {"Cambio de aceite", "Cambio de frenos", "Cambio de neumáticos", "Cambio de batería", "Cambio de luces"};
        List<Service> servicesList = List.of(new Service(LocalDate.of(2020, 1, 1), 1000, services[0]),
                new Service(LocalDate.of(2020, 1, 1), 1000, services[1]),
                new Service(LocalDate.of(2020, 1, 1), 1000, services[2]),
                new Service(LocalDate.of(2020, 1, 1), 1000, services[3]),
                new Service(LocalDate.of(2020, 1, 1), 0, services[4]));
        vehicules.add(new Vehicule(vehicules.size()+1,"Ford", "Fiesta", LocalDate.of(2005, 1, 1), 1000, 4, 1000000, "ARS", servicesList));
        vehicules.add(new Vehicule(vehicules.size()+1,"Ford", "Focus", LocalDate.of(2020, 1, 1), 1000, 4, 1000000, "COL",servicesList ));
        vehicules.add(new Vehicule(vehicules.size()+1,"Ford", "Falcon", LocalDate.of(2021, 1, 1), 1000, 4, 1000000, "VEN", servicesList));
        vehicules.add(new Vehicule(vehicules.size()+1,"Ford", "F100", LocalDate.of(2020, 1, 1), 1000, 4, 1000000, "BRA", servicesList));
        vehicules.add(new Vehicule(vehicules.size()+1,"Ford", "F150", LocalDate.of(2024, 1, 1), 1000, 4, 1000000, "PAN",servicesList ));
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public Vehicule findById(int id)
    {
        return vehicules.stream().filter(vehicule -> vehicule.getId() == id).findFirst().orElse(null);
    }

    public void addVehicule(Vehicule vehicule)
    {
        vehicules.add(vehicule);
    }

    public List<Vehicule> findByDateCreation(LocalDate dateInitial, LocalDate dateFinal) {
        return vehicules.stream()
                .filter(x -> x.getManufacturingDate().isEqual(dateInitial) ||
                        x.getManufacturingDate().isEqual(dateFinal) ||
                        (x.getManufacturingDate().isAfter(dateInitial) &&
                                x.getManufacturingDate().isBefore(dateFinal)))
                .toList();
    }


    public List<Vehicule> findByPrice(int since, int to) {
        return vehicules.stream().filter(x-> x.getPrice() >= since && x.getPrice() <= to).toList();
    }



}
