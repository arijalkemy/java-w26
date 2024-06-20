package com.mercadolibre.fresh_market.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_details")
public class CartDetail {

    @EmbeddedId
    private ShoppingCartKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonBackReference
    @ToString.Exclude
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
}