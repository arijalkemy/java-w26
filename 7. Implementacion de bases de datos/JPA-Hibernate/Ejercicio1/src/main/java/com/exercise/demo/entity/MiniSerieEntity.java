package com.exercise.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double rating;
    private int amount_of_awards;
}
