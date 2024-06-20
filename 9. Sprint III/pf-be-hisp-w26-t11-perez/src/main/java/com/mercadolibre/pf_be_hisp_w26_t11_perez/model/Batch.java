package com.mercadolibre.pf_be_hisp_w26_t11_perez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "batches", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"batch_number"})
})
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer batchNumber;
    private Double currentTemperature;
    private Double minimumTemperature;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingTime;
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "inboud_order_id", nullable = false)
    private InboundOrder inboudOrder;


    public boolean isExpiredBy(LocalDate limitDate) {


        return dueDate.isAfter(limitDate) || dueDate.isEqual(limitDate);
    }


    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchNumber=" + batchNumber +
                ", currentTemperature=" + currentTemperature +
                ", minimumTemperature=" + minimumTemperature +
                ", initialQuantity=" + initialQuantity +
                ", currentQuantity=" + currentQuantity +
                ", manufacturingDate=" + manufacturingDate +
                ", manufacturingTime=" + manufacturingTime +
                ", dueDate=" + dueDate +
                '}';
    }
}
