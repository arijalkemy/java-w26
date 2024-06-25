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
@Embeddable
public class ProductOrder {
    @ManyToOne
    @JoinColumn (name = "product_id", referencedColumnName =  "id", nullable = false)
    private Product product;
    @Column (name = "quantity")
    private Integer quantity;
}
