package org.example;

public interface Impresora {
    static void imprimir(Impresora impresora){
        System.out.println(impresora.toString());
    };
}
