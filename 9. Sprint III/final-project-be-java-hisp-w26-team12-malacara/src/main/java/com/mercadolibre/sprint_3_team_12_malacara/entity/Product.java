package com.mercadolibre.sprint_3_team_12_malacara.entity;

import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")

@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category type;

    @OneToMany(mappedBy = "product")
    private List<ProductInCart> productInCarts;

    @OneToMany(mappedBy = "product")
    private List<BatchStock> batchStocks;

}
