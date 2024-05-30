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
@Table(name = "actor_episode")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", nullable = false, referencedColumnName = "id")
    Actor actor_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_id", nullable = false, referencedColumnName = "id")
    Episode episode_id;
}
