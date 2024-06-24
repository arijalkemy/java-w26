package com.mercadolibre.hqltest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = true)
    private Date created_at;

    @Column(nullable = true)
    private Date updated_at;

    private String title;
    private float rating;
    private int awards;
    private Date release_date;
    private int length;

    @OneToOne
    private Genre genre;
}
