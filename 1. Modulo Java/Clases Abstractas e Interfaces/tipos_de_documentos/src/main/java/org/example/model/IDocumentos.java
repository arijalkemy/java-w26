package org.example.model;

public interface IDocumentos<T> {

    default void imprimirDocumento(T documento){
        System.out.println(documento);
    }
}
