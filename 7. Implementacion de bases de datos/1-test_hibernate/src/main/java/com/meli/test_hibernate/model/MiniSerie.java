package com.meli.test_hibernate.model;

import com.meli.test_hibernate.enums.MiniseriesStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Mini_Series")
public class MiniSerie {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="rating")
    private Double rating;
    @Column(name="amount_of_awards")
    private Integer awards;
    @Column(name="mini_serie_status")
    @Enumerated(EnumType.STRING)
    private MiniseriesStatus miniseriesStatus;
}
