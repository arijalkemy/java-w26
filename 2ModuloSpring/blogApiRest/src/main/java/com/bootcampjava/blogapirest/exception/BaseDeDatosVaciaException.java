package com.bootcampjava.blogapirest.exception;

public class BaseDeDatosVaciaException extends RuntimeException{
    public BaseDeDatosVaciaException() {
        super("La base de datos esta vacia, por favor cargue algunos documentos para continuar");
    }
}
