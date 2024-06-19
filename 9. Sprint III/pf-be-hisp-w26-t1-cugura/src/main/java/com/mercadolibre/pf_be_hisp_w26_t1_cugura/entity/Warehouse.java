package com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WAREHOUSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    @Column(name="id_warehouse")
    private Integer id;
    private String name;
    private String city;
    private String province;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User manager;

}
