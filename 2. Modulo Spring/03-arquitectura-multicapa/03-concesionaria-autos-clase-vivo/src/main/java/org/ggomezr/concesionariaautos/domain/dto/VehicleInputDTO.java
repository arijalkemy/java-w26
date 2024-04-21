package org.ggomezr.concesionariaautos.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import org.ggomezr.concesionariaautos.domain.entity.Service;

import java.time.LocalDate;
import java.util.List;

@Getter
public class VehicleInputDTO {
    private Integer id;
    private String brand;
    private String model;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate manufacturingDate;

    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String counterOfOwners;

    private static Integer lastId = 0;

    public VehicleInputDTO(String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<Service> services, String counterOfOwners) {
        this.id = ++lastId;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.counterOfOwners = counterOfOwners;
    }
}
