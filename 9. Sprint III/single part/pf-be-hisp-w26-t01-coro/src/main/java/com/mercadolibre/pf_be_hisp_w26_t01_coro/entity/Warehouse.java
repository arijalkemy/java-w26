package com.mercadolibre.pf_be_hisp_w26_t01_coro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "WAREHOUSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
    @Id
    @Column(name="id_warehouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private String province;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User manager;

}
