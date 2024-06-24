package com.mercadolibre.final_project_java_hisp_w26_t6.entity;

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
@Table(name = "batches")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long id;

    @Column(name = "batch_number")
    private Integer batchNumber;

    @Column(name = "current_temperature")
    private Double currentTemperature;

    @Column(name = "minimum_temperature")
    private Double minimumTemperature;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "manufacturing_date_time")
    private LocalDateTime manufacturingDateTime;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
