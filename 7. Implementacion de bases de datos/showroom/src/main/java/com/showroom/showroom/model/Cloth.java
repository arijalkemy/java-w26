package com.showroom.showroom.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "clothes" )
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cloth {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    @Column( name = "id")
    private Long id;
    @Column( name = "name")
    private String name;
    @Column( name = "type")
    private String type;
    @Column( name = "brand")
    private String brand;
    @Column( name = "size")
    private String size;
    @Column( name = "color")
    private String color;
    @Column( name = "price")
    private double price;
}
