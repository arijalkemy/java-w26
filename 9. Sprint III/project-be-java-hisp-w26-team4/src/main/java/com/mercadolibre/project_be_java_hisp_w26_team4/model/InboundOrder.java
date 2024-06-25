package com.mercadolibre.project_be_java_hisp_w26_team4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InboundOrder {
    @Id
    @Column (name = "order_number")
    private Long id;
    @Column (name = "order_date")
    private LocalDate orderDate;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn (name = "order_number")
    private List<Batch> batchList;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "warehouse_id", referencedColumnName = "id", nullable = false)
    private Warehouse warehouse;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "section_id", referencedColumnName = "id", nullable = false)
    private Section section;

}
