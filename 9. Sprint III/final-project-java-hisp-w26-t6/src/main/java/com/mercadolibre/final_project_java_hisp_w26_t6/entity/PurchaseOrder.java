package com.mercadolibre.final_project_java_hisp_w26_t6.entity;


import com.mercadolibre.final_project_java_hisp_w26_t6.util.OrderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "type")
    private OrderType type;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<PurchaseOrderDetail> purchaseOrderDetails;
}
