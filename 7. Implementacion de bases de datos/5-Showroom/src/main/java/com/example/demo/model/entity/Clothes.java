package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double salePrice;

    @ManyToMany(mappedBy = "clothesList")
    private List<Sale> sale;

}
