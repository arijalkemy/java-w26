package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long number;
    private LocalDate date;
    private Integer total;
    private String paymentMethod;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sales_clothes",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "clothe_id"))
    private List<Cloth> clothes;

}
