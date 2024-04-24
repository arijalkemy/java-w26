package org.example.blog.exception;

public class EntradaBlogNoEncontradaException extends RuntimeException {

    public EntradaBlogNoEncontradaException(int id) {
        super("No se encontró una Entrada de Blog con id=" + id);
    }
}
