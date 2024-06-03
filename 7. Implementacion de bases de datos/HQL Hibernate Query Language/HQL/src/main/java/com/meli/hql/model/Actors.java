package com.meli.hql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table("actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
