package com.bootcampW22.EjercicioGlobal.utils;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.lang.reflect.Field;

public class Util {

    public static boolean tieneCampoNuloVehicle(VehicleDto objeto) {

           return objeto.getId() == 0 || objeto.getColor() == null || objeto.getBrand() == null || objeto.getModel() == null
                   || objeto.getWeight() == 0;
       }
}
