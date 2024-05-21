package com.example.productoselastic.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double pCosto;
    private Double pVenta;
    private int stock;
}
