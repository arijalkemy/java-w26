package com.showroom.showroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "sales")
@Getter @Setter
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    @Column( name = "id")
    private Long id;

    @Column( name = "date" )
    private LocalDate date;

    @Column( name = "total_price")
    private double totalPrice;

    @Column( name = "payment_method")
    private String paymentMethod;

}
