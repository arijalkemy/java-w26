package com.bootcamp.course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identification;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Double note1;
    private Double note2;

}
