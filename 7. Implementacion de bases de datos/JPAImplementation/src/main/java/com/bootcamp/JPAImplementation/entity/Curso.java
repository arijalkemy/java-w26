package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.sound.midi.Sequence;
import java.util.Set;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre_curso;
    @OneToOne
    @JoinColumn(name = "docente_id", referencedColumnName = "id")
    private Docente profesor;
    @ManyToMany
    @JoinTable(name="ayudantes_cursos", joinColumns = @JoinColumn(name="curso_id"),
            inverseJoinColumns =  @JoinColumn(name="docente_id"))
    Set<Docente> ayudantes;
}
