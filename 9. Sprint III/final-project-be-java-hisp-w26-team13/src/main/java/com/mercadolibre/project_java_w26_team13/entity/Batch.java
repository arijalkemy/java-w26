package com.mercadolibre.project_java_w26_team13.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "batchs")
public class Batch {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;

        private String batchNumber;
        private double currentTemperature;
        private double minimumTemperature;
        private int initialQuantity;
        private int currentQuantity;
        private LocalDate manufacturingDate;
        private LocalTime manufacturingTime;
        private LocalDate dueDate;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "order_id", nullable = false)
        private Order order;
}
