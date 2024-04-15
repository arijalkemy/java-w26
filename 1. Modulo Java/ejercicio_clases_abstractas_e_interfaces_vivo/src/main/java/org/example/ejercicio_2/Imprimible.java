package org.example.ejercicio_2;

public interface Imprimible {
    static void imprimir(Imprimible documento) {
        System.out.println(documento.contenido());
    }

    public abstract String contenido();
}
