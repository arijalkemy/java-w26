package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.baseDeDatos.DataBase;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Ejercicio10ConcesionarioAutosApplication {

	public static void main(String[] args) {
		cargarDatos();
		SpringApplication.run(Ejercicio10ConcesionarioAutosApplication.class, args);
	}

	public static void cargarDatos() {
		Map<Integer, Vehicle> vehicles = new HashMap<>();
		Map<Integer, Service> services = new HashMap<>();

		vehicles.put(1, new Vehicle(1, "Chevrolet", "Corsa", LocalDate.of(2000, 11, 20), 115000, 5, 90000.0, "AR", 2));
		vehicles.put(2, new Vehicle(2, "Ford", "Focus", LocalDate.of(2015, 5, 15), 50000, 4, 120000.0, "US", 1));
		vehicles.put(3, new Vehicle(3, "Toyota", "Corolla", LocalDate.of(2018, 8, 25), 30000, 4, 150000.0, "JP", 1));
		vehicles.put(4, new Vehicle(4, "Honda", "Civic", LocalDate.of(2010, 3, 10), 80000, 4, 80000.0, "US", 2));
		vehicles.put(5, new Vehicle(5, "Volkswagen", "Golf", LocalDate.of(2017, 7, 5), 40000, 5, 110000.0, "DE", 1));
		vehicles.put(6, new Vehicle(6, "BMW", "3 Series", LocalDate.of(2019, 11, 30), 20000, 4, 180000.0, "DE", 1));
		vehicles.put(7, new Vehicle(7, "Mercedes-Benz", "C-Class", LocalDate.of(2016, 6, 20), 60000, 4, 140000.0, "DE", 1));
		vehicles.put(8, new Vehicle(8, "Audi", "A4", LocalDate.of(2014, 9, 12), 70000, 4, 130000.0, "DE", 1));
		vehicles.put(9, new Vehicle(9, "Nissan", "Altima", LocalDate.of(2017, 4, 25), 45000, 4, 100000.0, "JP", 1));
		vehicles.put(10, new Vehicle(10, "Hyundai", "Elantra", LocalDate.of(2016, 8, 8), 55000, 4, 95000.0, "KR", 1));

		services.put(1, new Service(1, 1, LocalDate.of(2003, 5, 20), 60000, "Change air filters"));
		services.put(2, new Service(2, 2, LocalDate.of(2016, 2, 10), 30000, "Oil change"));
		services.put(3, new Service(3, 3, LocalDate.of(2019, 10, 5), 20000, "Replace tires"));
		services.put(4, new Service(4, 4, LocalDate.of(2013, 8, 15), 70000, "Change brake pads"));
		services.put(5, new Service(5, 5, LocalDate.of(2018, 12, 1), 25000, "Transmission flush"));
		services.put(6, new Service(6, 6, LocalDate.of(2020, 5, 20), 10000, "Coolant flush"));
		services.put(7, new Service(7, 7, LocalDate.of(2017, 6, 8), 50000, "Replace spark plugs"));
		services.put(8, new Service(8, 8, LocalDate.of(2015, 3, 25), 60000, "Change timing belt"));
		services.put(9, new Service(9, 9, LocalDate.of(2019, 11, 12), 40000, "Rotate tires"));
		services.put(10, new Service(10, 10, LocalDate.of(2018, 9, 30), 30000, "Change engine oil"));
		services.put(11, new Service(11, 1, LocalDate.of(2005, 8, 10), 80000, "Replace clutch"));
		services.put(12, new Service(12, 1, LocalDate.of(2010, 6, 25), 100000, "Engine overhaul"));
		services.put(13, new Service(13, 4, LocalDate.of(2015, 4, 20), 85000, "Change suspension"));
		services.put(14, new Service(14, 5, LocalDate.of(2020, 1, 15), 45000, "Alignment and balancing"));
		services.put(15, new Service(15, 6, LocalDate.of(2021, 7, 10), 30000, "Spark plug replacement"));
		services.put(16, new Service(16, 9, LocalDate.of(2018, 12, 5), 60000, "Brake fluid change"));


		DataBase.getBaseDeDatos().setServices(services);
		DataBase.getBaseDeDatos().setVehicles(vehicles);
	}

}
