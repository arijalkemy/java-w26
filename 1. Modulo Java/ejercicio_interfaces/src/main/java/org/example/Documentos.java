package org.example;

public interface Documentos<T> {


    static <T> void imprimeDocumento(T documento){
        System.out.println(documento.toString());
    }

}
