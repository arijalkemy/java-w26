package com.showroom.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "sale_details" )
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn( name = "cloth_id")
    private Cloth cloth;

    @Column( name = "quantity")
    private int quantity;

    @Column( name = "price")
    private double price;



}
