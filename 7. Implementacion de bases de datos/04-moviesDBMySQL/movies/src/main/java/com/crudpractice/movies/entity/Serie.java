package com.crudpractice.movies.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="series")
public class Serie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name= "title")
    private String title;
    @Column(name= "release_date")
    private Date releaseDate;
    @Column(name= "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name= "genre_id")
    private Genre genre;
    @OneToMany
    @JoinColumn(name= "serie_id")
    @JsonManagedReference
    private List<Season> seasons;
}
