package com.w26.movies.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Entity
@Table(name = "seasons")
public class Season implements Serializable {
    @Id
    Integer id;

    String title;
    Integer number;

    @Column(columnDefinition = "date")
    LocalDateTime release_date;

    @Column(columnDefinition = "date")
    LocalDateTime end_date;

    @OneToOne
    @JoinColumn(name = "serie_id")
    @JsonBackReference
    Serie serie;
    
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
