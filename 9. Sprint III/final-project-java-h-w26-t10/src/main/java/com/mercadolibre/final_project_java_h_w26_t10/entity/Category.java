package com.mercadolibre.final_project_java_h_w26_t10.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "category")
    private Set<Sector> sectors = new LinkedHashSet<>();

}
