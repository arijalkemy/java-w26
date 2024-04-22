package org.miprimerproyecto.consesionariaautos.service;

import org.miprimerproyecto.consesionariaautos.dto.VehicleDTO;
import org.miprimerproyecto.consesionariaautos.model.Vehicle;
import org.miprimerproyecto.consesionariaautos.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehiculeRepository vehiculeRepository;
    private int id=0;

    @Override
    public void createVehicle(VehicleDTO vehicle) {
        Vehicle vehicle1= new Vehicle(id+1,vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(),
                vehicle.getNumerOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(),
                vehicle.getListServices(), vehicle.getCountOfOwners());
        vehiculeRepository.createVehicle(vehicle1);
        id++;
    }

    @Override
    public List<VehicleDTO> getVehicules() {
        List<Vehicle> vehicles= vehiculeRepository.getVehicules();
        List<VehicleDTO> listaDTO= new ArrayList<>();
        for (Vehicle element : vehicles) {
            listaDTO.add(new VehicleDTO(element.getBrand(), element.getModel(),
                    element.getManufacturingDate(), element.getNumerOfKilometers(), element.getDoors(),
                    element.getPrice(), element.getCurrency(), new ArrayList<>(), element.getCountOfOwners() ));
        }
        return listaDTO;
    }


    @Override
    public List<VehicleDTO> getVehiculeByDate(String date) {
        List<Vehicle> vehiclesAux= vehiculeRepository.getVehiculeByDate(date);
        List<VehicleDTO> listaDTO= new ArrayList<>();
        for (Vehicle element : vehiclesAux) {
            listaDTO.add(new VehicleDTO(element.getBrand(), element.getModel(),
                    element.getManufacturingDate(), element.getNumerOfKilometers(), element.getDoors(),
                    element.getPrice(), element.getCurrency(), element.getListServices(), element.getCountOfOwners() ));
        }
        return listaDTO;
    }

    @Override
    public List<VehicleDTO> getVehiculeByRangePrice(int min, int max) {
        List<Vehicle> vehiclesAux= vehiculeRepository.getVehiculeByRangePrice(min, max);
        List<VehicleDTO> listaDTO= new ArrayList<>();
        for (Vehicle element : vehiclesAux) {
            listaDTO.add(new VehicleDTO(element.getBrand(), element.getModel(),
                    element.getManufacturingDate(), element.getNumerOfKilometers(), element.getDoors(),
                    element.getPrice(), element.getCurrency(), element.getListServices(), element.getCountOfOwners()));
        }
        return listaDTO;
    }

    @Override
    public VehicleDTO getVehiculeById(int id) {
        Vehicle element = vehiculeRepository.getVehiculeById(id);
        VehicleDTO response= new VehicleDTO(element.getBrand(), element.getModel(),
                element.getManufacturingDate(), element.getNumerOfKilometers(), element.getDoors(),
                element.getPrice(), element.getCurrency(), element.getListServices(), element.getCountOfOwners());
        return response;
    }
}
