package com.mercadolibre.final_project_java_hisp_w26_t6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_code")
    private Integer warehouseCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "warehouse_code")
    private List<Sector> sectors;

    @OneToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private User supervisor;
}
