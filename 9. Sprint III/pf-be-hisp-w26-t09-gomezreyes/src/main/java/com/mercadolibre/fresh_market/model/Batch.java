package com.mercadolibre.fresh_market.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "initial_quantity")
    private Integer initialQuantity;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "due_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dueDate;

    @Column(name = "manufacturing_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate manufacturingDate;

    @Column(name = "manufacturing_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime manufacturingTime;

    @Column(name = "batch_number")
    private Integer batchNumber;

    @Column(name = "current_temperature")
    private Double currentTemperature;

    @Column(name = "minimum_temperature")
    private Double minimumTemperature;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "inbound_order_id", nullable = false)
    private InboundOrder inboundOrder;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "section_id")
    private Section section;
}