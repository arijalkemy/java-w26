package com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product", indexes = {
        @Index(name = "category_id", columnList = "category_id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "product")
    private Set<Batch> batches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ShoppingCartProduct> shoppingCartProducts = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserAccount seller;

}