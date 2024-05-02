package com.meli.obtenerdiploma.exception;

public class StudentAllreadyExistException extends RuntimeException {


    public StudentAllreadyExistException(Long id) {
        super("El alumno con Id " + id + " ya se encuentra registrado.");
    }
}
