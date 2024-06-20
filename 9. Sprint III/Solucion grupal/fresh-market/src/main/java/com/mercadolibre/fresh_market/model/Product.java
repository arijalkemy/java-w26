package com.mercadolibre.fresh_market.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<CartDetail> cartDetails;

    @JsonCreator
    public Product(Long id) {
        this.id = id;
    }
}
