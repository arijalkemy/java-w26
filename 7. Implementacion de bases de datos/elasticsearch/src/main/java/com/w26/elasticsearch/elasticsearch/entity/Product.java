package com.w26.elasticsearch.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "product")
public class Product {

    @Id
    private String id;
    
    private String name;
    private String type; //Esto podría ser un Enum?
    private Double priceOfSell;
    private Integer countAvailble;

}
