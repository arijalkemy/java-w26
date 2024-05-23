package com.example.comprarclavecompuesta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "compra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    private LocalDate sellDate;

    @Column(name = "purchase_value")
    private Double value;

    @PrePersist
    public void prePersist() {
        sellDate = LocalDate.now();
    }
}
