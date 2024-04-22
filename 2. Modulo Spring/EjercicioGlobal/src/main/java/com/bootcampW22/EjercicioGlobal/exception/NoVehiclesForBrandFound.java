package com.bootcampW22.EjercicioGlobal.exception;

public class NoVehiclesForBrandFound extends RuntimeException{
    public NoVehiclesForBrandFound() {
    }

    public NoVehiclesForBrandFound(String message) {
        super(message);
    }
}
