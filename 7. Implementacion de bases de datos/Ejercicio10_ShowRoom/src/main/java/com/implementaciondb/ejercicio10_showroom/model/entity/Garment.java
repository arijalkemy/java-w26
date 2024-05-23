package com.implementaciondb.ejercicio10_showroom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clothes")
public class Garment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @Column(name = "size", nullable = false, length = 10)
    private Integer size;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "sale_price", nullable = false)
    private Double salePrice;

}
