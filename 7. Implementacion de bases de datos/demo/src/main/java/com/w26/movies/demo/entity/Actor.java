package com.w26.movies.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actor {
    @Id
    Integer id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;
    
    @Column(columnDefinition = "DECIMAL")
    BigDecimal rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "favorite_movie_id")
    @JsonBackReference
    Movie favoriteMovie;

    LocalDateTime created_at;
    LocalDateTime updated_at;
}
