package com.hql.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table( name = "genres")
@Getter @Setter
public class Genre {
    @Id
    @GeneratedValue
    private int id;
    @Column( name = "created_at")
    LocalDateTime createdAt;
    @Column( name = "updated_at")
    LocalDateTime updatedAt;
    private String name;
    private int ranking;
    private boolean active;
}
