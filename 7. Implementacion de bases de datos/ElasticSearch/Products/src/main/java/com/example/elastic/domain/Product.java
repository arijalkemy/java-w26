package com.example.elastic.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "blog")
@Getter @Setter
public class Product {
    @Id
    private int id;
    private String name;
    private String type;
    private Double sale_price;
    private Double cost_price;
    private Integer quantity;
}
