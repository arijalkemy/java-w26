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
@Table(name = "episodes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    Integer number;
    LocalDate release_date;
    Double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false, referencedColumnName = "id")
    Season season_id;
}
