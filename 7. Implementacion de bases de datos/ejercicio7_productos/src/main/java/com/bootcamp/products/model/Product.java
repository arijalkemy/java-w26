package com.bootcamp.products.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

@Document(indexName = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;
    private Integer amount;

    @Field(name = "cost_price")
    private Double costPrice;

    @Field(name = "sale_price")
    private Double salePrice;

}
