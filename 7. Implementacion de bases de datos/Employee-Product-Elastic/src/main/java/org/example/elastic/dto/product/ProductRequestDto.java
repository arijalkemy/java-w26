package org.example.elastic.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String id;
    private String name;
    private String type;
    private Double price;
    private Integer stock;
}
