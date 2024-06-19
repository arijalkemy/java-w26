package com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SECTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @Column(name = "id_section")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @Column(name = "max_batch_capacity")
    private Integer maxBatchCapacity;
}
