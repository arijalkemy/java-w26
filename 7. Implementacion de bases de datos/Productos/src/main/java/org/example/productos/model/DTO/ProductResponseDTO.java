package org.example.productos.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private String id;
    private String name;
    private String type;
    private Double price;
    private Double costPrice;
    private Integer quantity;
}
