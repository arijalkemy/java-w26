package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sales")
public class Sales {
    //numero, fecha, total, medio de pago, lista de prendas.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    private double total;
    private String methodOfPay;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sales_clothes", joinColumns =@JoinColumn(name="sale_id")
            , inverseJoinColumns = @JoinColumn(name = "clothes_id"))
    private List<Clothes> listOfClothes;
}
