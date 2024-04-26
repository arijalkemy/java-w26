package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

public class VehicleValidator {

    public static boolean verifyData(VehicleDto vehicleDto) {
        if (vehicleDto.getId() == null || vehicleDto.getId() < 0) {
            return false;
        }
        if (vehicleDto.getBrand() == null || vehicleDto.getBrand().isEmpty()) {
            return false;
        }
        if (vehicleDto.getModel() == null || vehicleDto.getModel().isEmpty()) {
            return false;
        }
        if (vehicleDto.getRegistration() == null
                || vehicleDto.getRegistration() == ""
                || !vehicleDto.getRegistration().matches("\\d+")
        ) {
            return false;
        }
        if (Integer.parseInt(vehicleDto.getRegistration()) <= 0) {
            return false;
        }
        if (vehicleDto.getColor() == null || vehicleDto.getColor() == "") {
            return false;
        }
        if (vehicleDto.getYear() <= 1900) {
            return false;
        }
        if (vehicleDto.getMax_speed() == null
                || vehicleDto.getMax_speed().isEmpty()
                || !vehicleDto.getMax_speed().matches("\\d+")
        ) {
            return false;
        }
        if (Integer.parseInt(vehicleDto.getMax_speed()) <= 0) {
            return false;
        }
        if (vehicleDto.getPassengers() <= 0) {
            return false;
        }
        if (vehicleDto.getFuel_type() == null || vehicleDto.getFuel_type().isEmpty()) {
            return false;
        }
        if (vehicleDto.getTransmission() == null || vehicleDto.getTransmission().isEmpty()) {
            return false;
        }
        if (vehicleDto.getHeight() <= 0.0) {
            return false;
        }
        if (vehicleDto.getWidth() <= 0.0) {
            return false;
        }
        if (vehicleDto.getWeight() <= 0.0) {
            return false;
        }
        return true;
    }

    public static boolean validateMaxSpeed(String maxSpeed) {
        if (maxSpeed == null || maxSpeed == "" || !maxSpeed.matches("\\d+")) {
            return false;
        }
        return Integer.parseInt(maxSpeed) > 0;
    }

    public static Double getDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }



}
