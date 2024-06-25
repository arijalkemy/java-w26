package com.mercadolibre.pf_be_hisp_w26_t07_torres.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_seller")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
