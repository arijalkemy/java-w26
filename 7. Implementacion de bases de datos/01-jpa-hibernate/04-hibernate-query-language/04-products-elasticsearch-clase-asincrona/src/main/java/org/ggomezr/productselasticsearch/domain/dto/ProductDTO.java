package org.ggomezr.productselasticsearch.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private String id;
    private String name;
    private String type;
    private Double sellingPrice;
    private Double costPrice;
    private Integer stock;
}
