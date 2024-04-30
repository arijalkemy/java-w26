package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
