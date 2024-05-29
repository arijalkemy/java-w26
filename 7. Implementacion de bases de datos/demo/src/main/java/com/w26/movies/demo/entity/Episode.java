package com.w26.movies.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "episodes")
public class Episode {
    @Id
    Integer id;

    String title;
    Integer number;

    @Column(columnDefinition = "date")
    LocalDateTime release_date;
    
    @Column(columnDefinition = "decimal")
    Double rating;

    LocalDateTime created_at;
    LocalDateTime updated_at;
}
