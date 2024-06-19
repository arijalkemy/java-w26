package com.mercadolibre.fresh_market.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mercadolibre.fresh_market.model.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "caracteristics")
    private String caracteristics;

    @Column(name = "sector_size")
    private Long sectorSize;

    @Column(name = "current_availability")
    private Long currentAvailability;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @JsonCreator
    public Section(Long id) {
        this.id = id;
    }
}
