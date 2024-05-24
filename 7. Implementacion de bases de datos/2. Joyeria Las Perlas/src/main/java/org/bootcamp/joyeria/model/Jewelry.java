package org.bootcamp.joyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewelrys")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String material;
    private float weight;
    private String particularity;
    @Column(name = "have_stone")
    boolean haveStone;
    @Column(name = "is_sell")
    boolean sell = true;
}
