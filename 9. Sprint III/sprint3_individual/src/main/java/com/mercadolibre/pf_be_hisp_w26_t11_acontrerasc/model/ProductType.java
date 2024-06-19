package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String acronym;

    public <E> ProductType(Integer i, String fresco, String fs, HashSet<E> es) {
    }

//    @OneToMany(mappedBy = "productType")
//    private Set<Section> sections;
}
