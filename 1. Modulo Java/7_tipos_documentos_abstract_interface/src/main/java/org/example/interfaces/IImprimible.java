package org.example.interfaces;

public interface IImprimible {
    static <T> void imprimir(T document){
        System.out.println(document);
    };
}
