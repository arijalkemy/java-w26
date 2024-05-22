package org.implementaciondb.ejercicio6_vehiculos_siniestros;

import jakarta.annotation.PostConstruct;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Sinister;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.repository.ISinisterRepository;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @PostConstruct
    public void init() {
        // Verificar si los datos ya se han cargado
        if (vehicleRepository.count() == 0) {
            // Generar vehículos de prueba
            List<Vehicle> vehicles = generateVehicles(15);
            vehicleRepository.saveAll(vehicles);
        }
    }

    private List<Vehicle> generateVehicles(int count) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Vehicle vehicle = Vehicle.builder()
                    .patent("PATENT" + (i + 1))
                    .brand("Brand" + (i + 1))
                    .model("Model" + (i + 1))
                    .manufactureYear(2020 + i)
                    .numberOfWheels(i + 1)
                    .build();
            vehicles.add(vehicle);
        }

        List<Sinister> sinisters = generateSinisters(vehicles);
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).setSinisters(sinisters.subList(i * 3, (i + 1) * 3));
        }

        return vehicles;
    }

    private List<Sinister> generateSinisters(List<Vehicle> vehicles) {
        List<Sinister> sinisters = new ArrayList<>();
        Random random = new Random();

        for (Vehicle vehicle : vehicles) {
            for (int i = 0; i < 3; i++) {
                Sinister sinister = Sinister.builder()
                        .sinisterDate(LocalDate.of(2023, 1, 1).plusDays(random.nextInt(365)))
                        .economicLoss(10000.0 + (i * 500))
                        .vehicle(vehicle)
                        .build();
                sinisters.add(sinister);
            }
        }
        return sinisters;
    }
}