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
@Table(name = "genres")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String name;
    Integer ranking;
    Integer active;
}
