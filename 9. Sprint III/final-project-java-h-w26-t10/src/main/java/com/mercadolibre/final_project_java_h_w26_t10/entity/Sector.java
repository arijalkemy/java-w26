package com.mercadolibre.final_project_java_h_w26_t10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sector", indexes = {
        @Index(name = "warehouse_id", columnList = "warehouse_id"),
        @Index(name = "category_id", columnList = "category_id")
})
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sector_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "sector")
    private Set<Batch> batches = new LinkedHashSet<>();

}
