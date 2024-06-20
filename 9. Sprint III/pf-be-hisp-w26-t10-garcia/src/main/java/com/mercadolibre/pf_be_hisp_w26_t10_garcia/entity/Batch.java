package com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "batch", indexes = {
        @Index(name = "product_id", columnList = "product_id"),
        @Index(name = "sector_id", columnList = "sector_id"),
        @Index(name = "inbound_id", columnList = "inbound_id")
})
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inbound_id")
    private InboundOrder inbound;

    @Column(name = "batch_number")
    private Integer batchNumber;

    @Column(name = "current_temperature")
    private Double currentTemperature;

    @Column(name = "minimum_temperature")
    private Double minimumTemperature;

    @Column(name = "initial_quantity")
    private Integer initialQuantity;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "manufacturing_time")
    private LocalTime manufacturingTime;

    @Column(name = "due_date")
    private LocalDate dueDate;

}