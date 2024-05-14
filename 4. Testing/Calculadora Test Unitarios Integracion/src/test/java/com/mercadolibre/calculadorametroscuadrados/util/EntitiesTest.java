package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;

public class EntitiesTest {

    public static HouseDTO casaTest() {
        return new HouseDTO("Casa Test","Avenida Siempreviva 742",
                Arrays.asList(new RoomDTO("Sala",5,5),
                        new RoomDTO("Dormitorio",4,4))
        );
    }
}
