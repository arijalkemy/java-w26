package org.implementaciondb.ejemplo5_onetomany.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "cart") // mappedBy es usado para definir el lado de la referencia de la relación
    private Set<Item> items;
}
