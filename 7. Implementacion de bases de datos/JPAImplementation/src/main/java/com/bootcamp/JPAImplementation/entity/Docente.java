package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "docentes")
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "cursos_a_cargo")
    @OneToMany(mappedBy = "docenteACargo")
    private List<Curso> cursosACargo;

    @Column(name = "cursos_mentor")
    @ManyToMany(mappedBy = "mentores")
    private List<Curso> cursosMentor;

    public Docente(String nombre, String apellido, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
    }
}
