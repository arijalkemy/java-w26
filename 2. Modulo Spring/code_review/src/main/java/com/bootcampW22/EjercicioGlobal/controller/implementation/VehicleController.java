package com.bootcampW22.EjercicioGlobal.controller.implementation;

import com.bootcampW22.EjercicioGlobal.controller.interfaces.IVehicleController;
import com.bootcampW22.EjercicioGlobal.dto.response.MessageResponse;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponse;
import com.bootcampW22.EjercicioGlobal.service.implementation.IVehicleService;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController implements IVehicleController {

    private final IVehicleService vehicleService;

    public ResponseEntity<Iterable<VehicleResponse>> getVehicles() {
        List<VehicleResponse> response = this.vehicleService.searchAllVehicles();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<MessageResponse> putUpdateSpeed(int id,@Positive double newSpeed) {

        MessageResponse response = this.vehicleService.updateVehicleMaxSpeed(id, newSpeed);

        return ResponseEntity.ok(response);
    }
}
