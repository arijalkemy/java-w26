package org.ggomezr.showroommysql.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClothingDTO {
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer stock;
    private Double price;
}
