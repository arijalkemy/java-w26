package org.bootcamp.showroom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "clothes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "clothe_type")
    private ClotheType clotheType;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "colour", nullable = false)
    private String colour;

    @Column(name = "waist", nullable = false)
    private String waist;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice;
}
