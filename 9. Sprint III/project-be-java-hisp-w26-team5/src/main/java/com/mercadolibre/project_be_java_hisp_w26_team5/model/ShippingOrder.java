package com.mercadolibre.project_be_java_hisp_w26_team5.model;

import com.mercadolibre.project_be_java_hisp_w26_team5.enums.ShippingOrderState;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "shipping_order")
public class ShippingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipping_order", nullable = false)
    private Integer id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_purchase_order", nullable = false)
    private PurchaseOrder purchaseOrder;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_source_warehouse", nullable = false)
    private Warehouse sourceWarehouse;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_destination", nullable = false)
    private Location buyerLocation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ShippingOrderState state;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private LocalDate dateUpdated;
}
