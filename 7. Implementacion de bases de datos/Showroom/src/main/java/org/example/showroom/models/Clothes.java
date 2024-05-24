package org.example.showroom.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", nullable = false)
    private Long code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "brand",nullable = false)
    private String brand;
    @Column(name = "color",nullable = false)
    private String color;
    @Column(name = "size",nullable = false)
    private String size;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
    @Column(name = "sell_price",nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal sellPrice;
}
