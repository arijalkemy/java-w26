package org.example.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vehicles.entities.Service;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleEntryDto {
    private String brand;
    private String model;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    @Override
    public String toString() {
        return "[DTO Entry] brand: " + brand + ", model: " + model + ", manufacturingDate: "
                + manufacturingDate + ", numberOfKilometers: " + numberOfKilometers + ", doors: " + doors + ", price: " + price;
    }
}
