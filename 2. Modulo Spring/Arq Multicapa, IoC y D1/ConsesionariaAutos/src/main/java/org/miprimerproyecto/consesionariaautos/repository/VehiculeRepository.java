package org.miprimerproyecto.consesionariaautos.repository;

import org.miprimerproyecto.consesionariaautos.exceptions.AlreadyExistsException;
import org.miprimerproyecto.consesionariaautos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculeRepository {
    List<Vehicle> listaVehicules= new ArrayList<Vehicle>();

    //Create
    public void createVehicle(Vehicle vehicle){
        if(listaVehicules.contains(vehicle)){
            throw new AlreadyExistsException("El vehiculo ya existe en el sistema");
        }
        listaVehicules.add(vehicle);
    }
    //Get All Vehicles
    public List<Vehicle> getVehicules(){

        return listaVehicules;
    }
    //GetByDateWithouServices
    public List<Vehicle> getVehiculeByDate(String date){
        List<Vehicle> vehicules = new ArrayList<>();
        for(Vehicle element : listaVehicules){
            if(element.getManufacturingDate().equals(date)){
                vehicules.add(element);
            }
            else {
                throw new IllegalArgumentException("La fecha enviada no coincide con ningun vehiculo");
            }
        }
        return vehicules;
    }
    //GetByRangePrice
    public List<Vehicle> getVehiculeByRangePrice(int min, int max){
        List<Vehicle> vehicules = new ArrayList<>();
        for(Vehicle element : listaVehicules){
            if (element.getPrice() >= min && element.getPrice() <= max){
                vehicules.add(element);
            }
            else {
                throw new IllegalArgumentException("Ningun vehiculo conicide con el rango");
            }
        }
        return vehicules;
    }
    public Vehicle getVehiculeById(int id){
        Vehicle vehicule = listaVehicules.stream().filter(element -> element.getId() == id).findFirst().get();
        if(vehicule.equals(null)){
            throw new IllegalArgumentException("El vehiculo no existe");
        }
        return vehicule;
    }

}
