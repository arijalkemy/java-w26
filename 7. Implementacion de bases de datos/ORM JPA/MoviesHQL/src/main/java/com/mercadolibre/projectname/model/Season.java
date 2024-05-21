package com.mercadolibre.projectname.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "end_date")
    private LocalDate endDate;
}
