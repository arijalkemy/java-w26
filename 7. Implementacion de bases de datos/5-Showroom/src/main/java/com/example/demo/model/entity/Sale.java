package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    @ManyToMany
    @JoinTable(name = "clothes_sale",
    joinColumns = @JoinColumn(name = "sale_id"),
    inverseJoinColumns = @JoinColumn(name = "clothes_code"))
    private List<Clothes> clothesList;
}
