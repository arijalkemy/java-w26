package org.bootcamp.concesionary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private String countOfOwners;
    private List<ServiceDTO> services;
}
