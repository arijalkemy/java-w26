package com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
