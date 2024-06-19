package com.mercadolibre.final_project_java_hisp_w26_t1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order_item")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_purchase_order")
    private PurchaseOrder purchaseOrder;
    private Integer quantity;
}
