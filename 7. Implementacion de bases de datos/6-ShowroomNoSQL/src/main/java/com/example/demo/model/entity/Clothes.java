package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "clothes")
public class Clothes {

    @Id
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double salePrice;
    private List<Sale> sale;

}
