package com.bootcampW22.EjercicioGlobal.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcampW22.EjercicioGlobal.dto.response.MessageResponse;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponse;

import jakarta.validation.constraints.Positive;

@RequestMapping("/vehicles")
public interface IVehicleController {
    
    @GetMapping
    ResponseEntity<Iterable<VehicleResponse>> getVehicles();
    

    @PutMapping("/{id}/{new_speed}")
    ResponseEntity<MessageResponse> putUpdateSpeed(@PathVariable int id, @Positive @PathVariable(name = "new_speed") double newSpeed);

}
