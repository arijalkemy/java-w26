package org.example.ejercicio2;

public interface IImprimible<T> {
     static <T> void imprimir(T documento) {
         System.out.println(documento.toString());
    }
}
