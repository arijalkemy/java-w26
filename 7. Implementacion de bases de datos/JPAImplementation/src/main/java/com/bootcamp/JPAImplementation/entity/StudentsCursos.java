package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "students_cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsCursos {
    @EmbeddedId
    private StudentCursosKey studentCursosKey;

    @Column(name = "notas")
    @OneToMany(mappedBy = "studentCurso")
    private List<Nota> notas;
}
