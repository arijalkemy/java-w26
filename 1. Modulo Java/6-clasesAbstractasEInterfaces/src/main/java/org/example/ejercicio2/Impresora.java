package org.example.ejercicio2;

public class Impresora implements IImprimible {

    @Override
    public void imprimir(Object documento) {
        System.out.println(documento.toString());
    }
}
