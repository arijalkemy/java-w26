package org.example.jewels.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "jewel")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private int weight;
    private String description;
    @Column(name = "has_stone")
    private boolean hasStone;
    @Column(name = "for_sale")
    private boolean forSale;
}
