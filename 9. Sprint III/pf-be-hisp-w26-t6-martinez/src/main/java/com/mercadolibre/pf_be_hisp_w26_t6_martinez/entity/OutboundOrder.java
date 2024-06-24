package com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.OutboundStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "outbound_orders")
public class OutboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OutboundStatus status;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "outbound_order_number")
    private List<Batch> batches;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
