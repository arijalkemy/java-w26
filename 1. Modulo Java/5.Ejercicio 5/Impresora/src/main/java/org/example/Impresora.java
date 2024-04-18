package org.example;

public abstract class Impresora {
    public static void imprimir(IDocumento documento) {
        System.out.println(documento.getDatos());
    }
}
