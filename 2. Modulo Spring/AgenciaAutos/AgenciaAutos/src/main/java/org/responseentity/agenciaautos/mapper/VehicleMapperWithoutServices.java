package org.responseentity.agenciaautos.mapper;

import org.responseentity.agenciaautos.dto.VehicleDTOWithoutServices;
import org.responseentity.agenciaautos.entity.VehicleEntity;

public class VehicleMapperWithoutServices {
    public static VehicleDTOWithoutServices entityToDTO(VehicleEntity vE){
        VehicleDTOWithoutServices ve = VehicleDTOWithoutServices.builder()
                .id(vE.getId())
                .brand(vE.getBrand())
                .model(vE.getModel())
                .manufacturingDate(vE.getManufacturingDate())
                .numberOfKilometers(vE.getNumberOfKilometers())
                .doors(vE.getDoors())
                .price(vE.getPrice())
                .currency(vE.getCurrency())
                .countOfOwners(vE.getCountOfOwners())
                .build();

        return ve;
    }
}
