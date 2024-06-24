package com.mercadolibre.project_java_w26_team13.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int buyerId;

    private LocalDate date;

    private String status;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<CartDetail> cartDetails;
}
