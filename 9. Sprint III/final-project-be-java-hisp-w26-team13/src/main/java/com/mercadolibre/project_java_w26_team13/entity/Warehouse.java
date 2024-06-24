package com.mercadolibre.project_java_w26_team13.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "warehouse_code")
    private Integer code;
    @OneToMany(mappedBy = "warehouse", fetch = FetchType.EAGER)
    private List<Section> sections;

}
