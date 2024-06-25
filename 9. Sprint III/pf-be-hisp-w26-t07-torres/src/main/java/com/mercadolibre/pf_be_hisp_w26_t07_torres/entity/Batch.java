package com.mercadolibre.pf_be_hisp_w26_t07_torres.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "batches")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "batch_number", nullable = false)
    private Long batchNumber;

    @Column(name = "current_temperature", precision = 10, scale = 2, nullable = false)
    private BigDecimal currentTemperature;

    @Column(name = "minimum_temperature", precision = 10, scale = 2, nullable = false)
    private BigDecimal minimumTemperature;

    @Column(name = "initial_quantity", nullable = false)
    private Integer initialQuantity;

    @Column(name = "current_quantity", nullable = false)
    private Integer currentQuantity;

    @Column(name = "manufacturing_date", columnDefinition = "DATE", nullable = false)
    private LocalDate manufacturingDate;

    @Column(name = "manufacturing_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime manufacturingTime;

    @Column(name = "due_date", columnDefinition = "DATE", nullable = false)
    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_seller_id", referencedColumnName = "id", nullable = false)
    private ProductSeller productSeller;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "representative_id", referencedColumnName = "id", nullable = false)
    private Representative representative;
}
