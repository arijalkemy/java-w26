package org.example.integradorvehiculossiniestros.service;

import org.example.integradorvehiculossiniestros.entity.dto.VehicleRequestDTO;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleResponseDTO;
import org.example.integradorvehiculossiniestros.entity.middle.Plate;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrand;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrandModel;

import java.util.List;

public interface IVehicleService {

    void saveVehicle(VehicleRequestDTO vehicleRequestDTO);
    List<VehicleResponseDTO> getAllVehicles();

    List<Plate> getAllPlates();
    List<PlateBrand> getAllPlatesBrandOrderedByDate();
    List<Plate> getAllPlatesByWheelsAndYear();
    List<PlateBrandModel> getAllDetailsByAccident();
    Double getTotalMoneyLoss();
}
