package org.miprimerproyecto.consesionariaautos.service;

import org.miprimerproyecto.consesionariaautos.dto.VehicleDTO;
import org.miprimerproyecto.consesionariaautos.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    void createVehicle(VehicleDTO vehicle);
    List<VehicleDTO> getVehicules();
    List<VehicleDTO> getVehiculeByDate(String date);
    List<VehicleDTO> getVehiculeByRangePrice(int min, int max);
    VehicleDTO getVehiculeById(int id);


}
