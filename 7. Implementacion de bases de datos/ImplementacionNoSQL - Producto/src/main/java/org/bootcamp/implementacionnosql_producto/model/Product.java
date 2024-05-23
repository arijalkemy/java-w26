package org.bootcamp.implementacionnosql_producto.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double sellPrice;
    private Double costPrice;
    private Integer stock;
}
