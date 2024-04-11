package org.example;

public class Impresora implements Imprimible{
    @Override
    public void imprimir(Object doc) {
        System.out.println(doc.toString());
    }
}
