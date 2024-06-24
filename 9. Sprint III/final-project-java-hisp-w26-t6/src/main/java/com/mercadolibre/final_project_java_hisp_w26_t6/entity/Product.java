package com.mercadolibre.final_project_java_hisp_w26_t6.entity;

import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private StorageType storageType;

    @Column(name = "unit_price")
    private Double unitPrice;

}
