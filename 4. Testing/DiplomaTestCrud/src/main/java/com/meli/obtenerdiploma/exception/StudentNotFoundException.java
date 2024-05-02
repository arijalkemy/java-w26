package com.meli.obtenerdiploma.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("El alumno con Id " + id + " no se encuetra registrado.");
    }

}
