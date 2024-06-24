package com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "batch_transfer_history")
public class TransferHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_number", nullable = false)
    private OutboundOrder orderNumber;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "from_warehouse_id", nullable = false)
    private Warehouse fromWarehouse;

    @ManyToOne
    @JoinColumn(name = "to_warehouse_id", nullable = false)
    private Warehouse toWarehouse;

    @Column(name = "transfer_date", nullable = false)
    private LocalDateTime transferDate;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;
}
