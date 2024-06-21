package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
