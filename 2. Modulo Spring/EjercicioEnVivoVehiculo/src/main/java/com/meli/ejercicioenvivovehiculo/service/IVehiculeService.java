package com.meli.ejercicioenvivovehiculo.service;

import com.meli.ejercicioenvivovehiculo.dto.VehiculeDTO;
import com.meli.ejercicioenvivovehiculo.model.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculeService {
    VehiculeDTO createVehicule(VehiculeDTO vehiculeDTO);
    VehiculeDTO getVehicule(int id);
    List<VehiculeDTO> getVehicules();
    List<VehiculeDTO> getVehiculeByManufactureDate(LocalDate dateInitial, LocalDate dateFinal);
    List<VehiculeDTO> getVehiculeByPrice(int since, int to);
}
