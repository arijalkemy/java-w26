package org.example;

public interface IImprimir<T> {
    static <T>void imprimir(T documento){
        System.out.println(documento.toString());
    }
}
