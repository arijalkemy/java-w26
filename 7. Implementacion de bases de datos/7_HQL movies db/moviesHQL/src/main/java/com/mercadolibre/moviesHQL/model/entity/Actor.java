package com.mercadolibre.moviesHQL.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "actor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String first_name;
    String last_name;
    Double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", nullable = false, referencedColumnName = "id")
    Movie favorite_movie_id;
}
