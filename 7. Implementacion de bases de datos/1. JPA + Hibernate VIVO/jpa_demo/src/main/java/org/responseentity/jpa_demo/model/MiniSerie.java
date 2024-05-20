package org.responseentity.jpa_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amount_of_awards;
}
