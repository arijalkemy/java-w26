package com.mercadolibre.sprint3_individual_perez.entity;

import com.mercadolibre.sprint3_individual_perez.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long id;

    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private Category type;

    @OneToMany(mappedBy = "section")
    private List<InboundOrder> inboundOrders;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;
}
