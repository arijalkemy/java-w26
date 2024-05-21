package com.bootcamp.JPAImplementation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identification;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<StudentCourseCalification> studentCourseCalifications;

    public Student (String identification, String name, String lastName) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
    }
}
