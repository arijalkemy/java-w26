package org.example.vehicles.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Vehicle not found")
public class VehicleNotFoundExeption extends RuntimeException {
    public VehicleNotFoundExeption(String message) {
        super(message);
    }
}
