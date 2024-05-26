package org.meli.ejercicio6_p1_d1_miniseries_mysql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "miniSeries")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_series")
    private Long id;
    @Column(name = "serie_name")
    private String name;
    @Column(name = "rating_name")
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amount_of_awards;
}
