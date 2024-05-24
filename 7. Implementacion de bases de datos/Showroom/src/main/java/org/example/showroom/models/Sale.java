package org.example.showroom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "sale_date", nullable = false)
    private LocalDate saleDate;

    @Column(name = "total_cost",nullable = false)
    private Double totalCost;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @ManyToMany
    @JoinTable(name = "sales_clothes",
            joinColumns = @JoinColumn ( name ="sale_number"),
            inverseJoinColumns = @JoinColumn  ( name = "clothes_code")
    )
    private List<Clothes> clothes;

}
