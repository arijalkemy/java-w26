package com.mercadolibre.sprint_3_valderrama.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "warehouse")
    private List<Section> sections;

    @ManyToMany(mappedBy = "warehouses")
    private List<User> people;
}
