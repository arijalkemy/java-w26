package org.mercadolibre.NotNullTeam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
