package com.w26.movies.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Data
@Table(name = "genres")
public class Genre {
    
    @Id
    Integer id;

    String name;
    Integer ranking;
    Boolean active;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Movie> movies;

    LocalDateTime created_at;
    LocalDateTime updated_at;

    
}
