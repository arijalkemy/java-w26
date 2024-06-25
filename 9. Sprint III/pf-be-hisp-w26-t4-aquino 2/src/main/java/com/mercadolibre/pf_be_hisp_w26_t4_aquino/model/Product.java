package com.mercadolibre.pf_be_hisp_w26_t4_aquino.model;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", nullable = false)
    private ProductType productType;
    @Column(name = "description")
    private String description;
    @Column (name = "product_price")
    private Double price;
}
