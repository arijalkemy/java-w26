package com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "BATCHES")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Batch {
    @Id
    @Column(name="id_batch")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_inbound_order")
    private InboundOrder inboundOrder;
    @Column(name="current_temperature")
    private Double currentTemperature;
    @Column(name="minimum_temperature")
    private Double minimumTemperature;
    @Column(name="initial_quantity")
    private Integer initialQuantity;
    @Column(name="current_quantity")
    private Integer currentQuantity;
    @Column(name="manufacturing_date")
    private LocalDate manufacturingDate;
    @Column(name="manufacturing_time")
    private LocalDateTime manufacturingTime;
    @Column(name="due_date")
    private LocalDate dueDate;


    public Double calculateDegreesAboveMinimum(){
        if(isWrongTemperature()){
        return currentTemperature - minimumTemperature;}
        return 0.0;
    }

    public boolean isWrongTemperature(){
        return currentTemperature > minimumTemperature;
    }




}
