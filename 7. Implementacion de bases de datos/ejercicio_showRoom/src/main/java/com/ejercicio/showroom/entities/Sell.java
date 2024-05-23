package com.ejercicio.showroom.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private LocalDate date;
    private double total;
    private String paymentMethod;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sell_id")
    private List<Clothe> clothes;

    public Sell() {
        date = LocalDate.now();
    }
}
