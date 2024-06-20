package com.mercadolibre.sprint_3_team_12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@IdClass(BatchStockKey.class)
@Table(name = "batch_stock")
public class BatchStock {
    @Id
    @Column(name = "batch_stock_id")
    private Long id;

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
    private LocalDateTime manufacturingTime;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @Id
    @JoinColumns({
            @JoinColumn(name = "inbound_order_id", referencedColumnName = "inbound_order_id"),
    })
    private InboundOrder inboundOrder;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}

class BatchStockKey implements Serializable {
    private Long id;
    private InboundOrder inboundOrder;
}
