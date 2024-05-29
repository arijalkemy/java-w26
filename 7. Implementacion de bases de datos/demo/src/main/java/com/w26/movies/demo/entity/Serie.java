package com.w26.movies.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "series")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Serie {
    @Id
    Integer id;

    String title;
    
    @Column(columnDefinition = "date")
    LocalDateTime release_date;

    @Column(columnDefinition = "date")
    LocalDateTime end_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="genre_id")
    @JsonBackReference
    Genre genero;

    LocalDateTime created_at;
    LocalDateTime updated_at;
}
