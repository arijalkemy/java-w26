package org.example.integradorproductemployee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document(indexName = "product")
public class Product {
    @Id
    private String id;

    private String name;
    private String type;
    private Double sellPrice;
    private Double fabricationPrice;
    private Integer stock;

}
