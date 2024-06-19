package com.mercadolibre.pf_be_hisp_w26_t11_perez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseOrderProduct> purchaseOrders;

    @OneToMany(mappedBy = "product")
    private Set<Batch> batches;
}
