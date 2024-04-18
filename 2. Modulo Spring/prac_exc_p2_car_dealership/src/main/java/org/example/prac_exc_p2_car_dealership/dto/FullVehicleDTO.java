package org.example.prac_exc_p2_car_dealership.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullVehicleDTO extends SimpleVehicleDTO implements Serializable {
    private List<CarServiceDTO> services;
}
