package com.mercadolibre.sprint_3_team_12_malacara.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Table(name = "inbound_order")
public class InboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
    @Column(name = "inbound_order_id")
    private Long id;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "inboundOrder")
    private List<BatchStock> batchStocks;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

