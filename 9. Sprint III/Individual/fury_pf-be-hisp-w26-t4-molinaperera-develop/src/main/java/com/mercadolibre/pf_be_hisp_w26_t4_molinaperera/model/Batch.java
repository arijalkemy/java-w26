package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="current_temperature")
    private Double currentTemperature;
    @Column(name="minimum_temperature")
    private Double minimumTemperature;
    @Column(name="manufacturing_date")
    private LocalDate manufacturingDate;
    @Column(name="initial_quantity")
    private Integer initialQuantity;
    @Column(name="current_quantity")
    private Integer currentQuantity;
    @Column(name="due_date")
    private LocalDate dueDate;
    @Column(name="manufacturing_time")
    private LocalDateTime manufacturingTime;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    InboundOrder inboundOrder;
}
