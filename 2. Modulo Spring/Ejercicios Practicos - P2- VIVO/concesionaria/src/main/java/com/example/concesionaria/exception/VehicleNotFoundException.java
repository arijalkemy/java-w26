package com.example.concesionaria.exception;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String message){
        super(message);
    }
}
