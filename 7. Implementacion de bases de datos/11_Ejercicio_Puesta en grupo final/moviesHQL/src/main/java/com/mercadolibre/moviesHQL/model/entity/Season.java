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
@Table(name = "seasons")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    Integer number;
    LocalDate release_date;
    LocalDate end_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id", nullable = false, referencedColumnName = "id")
    Serie serie_id;
}
