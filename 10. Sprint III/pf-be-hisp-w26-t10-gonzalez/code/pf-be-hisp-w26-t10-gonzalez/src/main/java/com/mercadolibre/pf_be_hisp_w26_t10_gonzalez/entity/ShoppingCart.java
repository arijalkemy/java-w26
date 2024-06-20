package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "order_state", length = 50)
    private String orderState;

    @Column(name = "total")
    private Double total;

    @OneToMany(mappedBy = "shoppingCart")
    private Set<ShoppingCartProduct> shoppingCartProducts = new LinkedHashSet<>();

}