package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer quantity;
    @Column( name = "sale_price")
    private double salePrice;
    @ManyToMany(mappedBy = "clothes")
    private List<Sale> sales;
}
