package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "warehouse", indexes = {
        @Index(name = "supervisor_id", columnList = "supervisor_id")
})
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    private UserAccount supervisor;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "warehouse")
    private Set<InboundOrder> inboundOrders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "warehouse")
    private Set<Sector> sectors = new LinkedHashSet<>();

}