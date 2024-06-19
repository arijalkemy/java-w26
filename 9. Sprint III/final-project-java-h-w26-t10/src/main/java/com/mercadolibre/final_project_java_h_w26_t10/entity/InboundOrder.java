package com.mercadolibre.final_project_java_h_w26_t10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "inbound_order", indexes = {
        @Index(name = "warehouse_id", columnList = "warehouse_id")
})
public class InboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inbound_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "order_number")
    private Integer orderNumber;

    @OneToMany(mappedBy = "inbound")
    private Set<Batch> batches = new LinkedHashSet<>();

}