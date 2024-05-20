package com.bootcamp.JPAImplementation.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@ToString
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Basic
    private String identification;
    @Basic
    private String name;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "student")
    private Set<Cursado> cursado;


    public Student (String identification, String name, String lastName) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
    }
}
