package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Data
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    private Integer number;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Series series;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes = new LinkedHashSet<>();

// Getters and setters
}