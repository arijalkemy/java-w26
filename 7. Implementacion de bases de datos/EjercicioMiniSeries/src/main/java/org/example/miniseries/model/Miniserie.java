package org.example.miniseries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Miniserie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String name;
    double rating;
    int amount_of_awards;
}
