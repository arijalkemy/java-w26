package com.mercadolibre.fresh_market.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "warehouseman_id", referencedColumnName = "id")
    private User warehouseman;

    @JsonCreator
    public Warehouse(Long id) {
        this.id = id;
    }
}
