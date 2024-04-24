package org.example.blog.exception;

public class EntradaBlogYaExiste extends RuntimeException {

    public EntradaBlogYaExiste(int id) {
        super("Ya existe una Entrada de Blog con id=" + id);
    }
}
