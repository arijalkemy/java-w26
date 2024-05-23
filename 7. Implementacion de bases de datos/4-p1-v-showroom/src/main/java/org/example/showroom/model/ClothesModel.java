package org.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clothes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String name;
    private String type;
    private String color;
    private float size;
    private String brand;
    private float price;
    private int stock;
}
