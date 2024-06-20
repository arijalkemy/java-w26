package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shopping_cart_product")
public class ShoppingCartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_product_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

}