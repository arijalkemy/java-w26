package com.mercadolibre.fresh_market.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartKey implements Serializable {
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "product_id")
    private Long productId;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

