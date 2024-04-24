package com.bootcampW22.EjercicioGlobal.service.implementation;

import java.util.List;

import com.bootcampW22.EjercicioGlobal.dto.response.MessageResponse;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponse;

public interface IVehicleService {

    List<VehicleResponse> searchAllVehicles();
    MessageResponse updateVehicleMaxSpeed(int id, Double speed);

}
