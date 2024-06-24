package com.mercadolibre.project_java_w26_team13.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderNumber;
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="section_id", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Batch> batchs;
}
