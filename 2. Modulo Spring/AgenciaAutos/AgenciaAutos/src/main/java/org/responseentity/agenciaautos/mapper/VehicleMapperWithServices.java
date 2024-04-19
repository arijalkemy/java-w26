package org.responseentity.agenciaautos.mapper;


import org.responseentity.agenciaautos.dto.VehicleDTOWithServices;
import org.responseentity.agenciaautos.entity.VehicleEntity;

public class VehicleMapperWithServices {
    public static VehicleDTOWithServices entityToDTO(VehicleEntity vE){
        return VehicleDTOWithServices.builder()
                .id(vE.getId())
                .brand(vE.getBrand())
                .model(vE.getModel())
                .manufacturingDate(vE.getManufacturingDate())
                .numberOfKilometers(vE.getNumberOfKilometers())
                .doors(vE.getDoors())
                .price(vE.getPrice())
                .services(vE.getServices())
                .currency(vE.getCurrency())
                .countOfOwners(vE.getCountOfOwners())
                .build();
    }

    public static VehicleEntity dtoToEntity(VehicleDTOWithServices dto){
       return VehicleEntity.builder()
               .id(dto.getId())
               .brand(dto.getBrand())
               .model(dto.getModel())
               .manufacturingDate(dto.getManufacturingDate())
               .numberOfKilometers(dto.getNumberOfKilometers())
               .doors(dto.getDoors())
               .price(dto.getPrice())
               .services(dto.getServices())
               .currency(dto.getCurrency())
               .countOfOwners(dto.getCountOfOwners())
               .build();
    }
}
