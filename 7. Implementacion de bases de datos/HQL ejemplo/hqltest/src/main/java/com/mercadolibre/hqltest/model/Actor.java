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
@Table(name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = true)
    private Date created_at;

    @Column(nullable = true)
    private Date updated_at;
    private String first_name;
    private String last_name;
    private float rating;

    @OneToOne
    private Movie favorite_movie;
}
