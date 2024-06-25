package com.mercadolibre.project_be_java_hisp_w26_team4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="capacity")
    private Integer capacity;
    @ManyToMany
    @JoinTable(
            name="section_batch",
            joinColumns=@JoinColumn(name = "section_id"),
            inverseJoinColumns=@JoinColumn(name = "batch_id")
    )
    private List<Batch> batches;
    @ManyToOne
    @JoinColumn(name="product_type", referencedColumnName = "id", nullable = false)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;
}
