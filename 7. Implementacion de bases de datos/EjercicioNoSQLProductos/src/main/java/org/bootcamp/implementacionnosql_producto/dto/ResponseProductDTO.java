package org.bootcamp.implementacionnosql_producto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private String id;
    private String name;
    private String type;
    private Double sellPrice;
    private Double costPrice;
    private Integer stock;
}
