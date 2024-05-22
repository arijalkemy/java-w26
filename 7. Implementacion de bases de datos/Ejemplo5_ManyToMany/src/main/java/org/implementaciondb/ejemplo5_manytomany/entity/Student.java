package org.implementaciondb.ejemplo5_manytomany.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable ( // Se usa para creaar una  nueva tabla externa (intermedia)
            name = "course_like", // Define el nombre de la nueva tabla
            joinColumns = @JoinColumn(name = "student_id"), // Definir la columna en la tabla externa que apunta al  id de la clase propietaria
            inverseJoinColumns = @JoinColumn(name = "course_id") // Definir la columna correspondiente al id de la otra tabla
    )
    private Set<Course> likedCourses;

}
