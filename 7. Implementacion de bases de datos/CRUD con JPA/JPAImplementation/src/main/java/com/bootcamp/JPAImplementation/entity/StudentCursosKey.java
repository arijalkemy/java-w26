package com.bootcamp.JPAImplementation.entity;

import java.io.Serializable;

public class StudentCursosKey implements Serializable {
    private Long studentId;
    private Long cursoId;

    public StudentCursosKey() {
    }

    public StudentCursosKey(Long studentId, Long cursoId) {
        this.studentId = studentId;
        this.cursoId = cursoId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
