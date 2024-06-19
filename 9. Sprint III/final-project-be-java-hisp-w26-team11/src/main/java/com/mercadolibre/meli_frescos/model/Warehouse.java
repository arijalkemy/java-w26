package com.mercadolibre.meli_frescos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "warehouse_code")
    private Integer warehouseCode;

    @OneToOne
    private User representative;

    @OneToMany(mappedBy = "warehouse")
    private Set<Section> sections;
}
