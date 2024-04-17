package co.com.mercadolibre.autos.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleDto {

    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private String countOfOwners;
}
