package com.showroom.showroomelastic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "clothes")
@Getter @Setter
public class Cloth {
    @Id
    private String id;
    private String name;
    private String type;
    private String brand;
    private String size;
    private String color;
    private int amount;
    private double sellPrice;
}
