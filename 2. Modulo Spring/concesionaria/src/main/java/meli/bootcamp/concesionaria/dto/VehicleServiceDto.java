package meli.bootcamp.concesionaria.dto;

import lombok.*;
import meli.bootcamp.concesionaria.entity.Service;
import meli.bootcamp.concesionaria.entity.Vehicle;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleServiceDto extends VehicleDto {
    private List<Service> services;

    public VehicleServiceDto(VehicleDto vehicle, List<Service> services) {
        super(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(), vehicle.getDoors(),
                vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners());
        this.services = services;
    }
}
