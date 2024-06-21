package com.mercadolibre.project_be_java_hisp_w26_team5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_batch", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "batch_number", nullable = false, length = 100, unique = true)
    private String batchNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sector", nullable = false)
    private Sector sector;

    @NotNull
    @Column(name = "current_temperature", nullable = false)
    private Double currentTemperature;

    @NotNull
    @Column(name = "minimum_temperature", nullable = false)
    private Double minimumTemperature;

    @NotNull
    @Column(name = "manufacturing_date", nullable = false)
    private LocalDate manufacturingDate;

    @NotNull
    @Column(name = "manufacturing_time", nullable = false)
    private LocalDateTime manufacturingTime;

    @NotNull
    @Column(name = "expiration_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "initial_quantity", nullable = false)
    private Integer initialQuantity;

    @NotNull
    @Column(name = "current_quantity", nullable = false)
    private Integer currentQuantity;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "entry_date")
    private Instant entryDate;

}