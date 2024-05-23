package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@Embeddable
public class StudentCursosKey implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "curso_id")
    private Long cursoId;

    public StudentCursosKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCursosKey that = (StudentCursosKey) o;

        if (!studentId.equals(that.studentId)) return false;
        return cursoId.equals(that.cursoId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentId, cursoId);
    }
}
