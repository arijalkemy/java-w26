package com.mercadolibre.pf_be_hisp_w26_t01_moises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "INBOUND_ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InboundOrder {
    @Id
    @Column(name="id_inbound_order")
    private Integer id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "id_section")
    private Section section;
    @OneToMany(mappedBy = "inboundOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Batch> batches;
}
