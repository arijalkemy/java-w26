package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.baseDeDatos;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static DataBase dataBase;
    private Map<Integer, Service> services;
    private Map<Integer, Vehicle> vehicles;

    public static DataBase getDataBase() {
        return dataBase;
    }

    public void addVehicle(Vehicle vehicle, Integer id) {
        vehicles.put(id, vehicle);
    }

    public void addService(Service service, Integer id) {
        services.put(id, service);
    }

    public Map<Integer, Service> getServices() {
        return services;
    }

    public void setServices(Map<Integer, Service> services) {
        this.services = services;
    }

    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<Integer, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    private DataBase() {
        services = new HashMap<>();
        vehicles = new HashMap<>();
    }

    public static DataBase getBaseDeDatos() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }
}
