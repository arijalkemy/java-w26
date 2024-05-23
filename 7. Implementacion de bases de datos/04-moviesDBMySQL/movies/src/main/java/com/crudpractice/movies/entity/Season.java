package com.crudpractice.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name="seasons")
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name= "title")
    private String title;
    @Column(name= "number")
    private int numberOfSeason;
    @Column(name= "release_date")
    private Date releaseDate;
    @Column(name= "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name= "serie_id")
    @JsonBackReference
    private Serie serie;
}
