package com.mercadolibre.sprint_3_valderrama.entity;

import com.mercadolibre.sprint_3_valderrama.enums.OrderStatus;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")

@Builder @Data

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "cart_date")
    private Date carDate;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<ProductInCart> products;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;
}
