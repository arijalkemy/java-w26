package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Docente {

    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String correo_electronico;
    //@OneToMany(mappedBy = "docente")
    //private List<Curso> cursos;

}
