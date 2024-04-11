package org.bootcamp.ejercicio2.interfaces;

public interface Documento<T> {
    default void imprimir(T documento) {
        System.out.println(documento.toString());
    }
}
