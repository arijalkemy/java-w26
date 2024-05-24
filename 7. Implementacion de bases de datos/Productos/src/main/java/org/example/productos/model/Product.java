package org.example.productos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double price;
    private Double costPrice;
    private Integer quantity;
}
