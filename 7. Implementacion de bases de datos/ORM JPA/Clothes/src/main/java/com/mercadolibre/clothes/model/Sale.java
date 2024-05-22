package com.mercadolibre.clothes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long number;
    private LocalDate date;
    private Double total;
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "sale_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "cloth_id", nullable = false),
            name = "sale_item"
    )
    private Set<Cloth> clothList;
}
