package com.mercadolibre.final_project_java_hisp_w26_t1.entity;

import jakarta.persistence.*;
import jnr.constants.platform.Local;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PURCHASE_ORDERS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_purchase_order")
    private Integer id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_purchase_order")
    private List<OrderItem> orderItems;

    public PurchaseOrder(Integer id, LocalDate date, User user) {
        this.id = id;
        this.date = date;
        this.user = user;
    }
}
