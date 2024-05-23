package org.miprimerproyecto.elasticproduct.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double priceSale;
    private Double costPrice;
    private int stock;
}
