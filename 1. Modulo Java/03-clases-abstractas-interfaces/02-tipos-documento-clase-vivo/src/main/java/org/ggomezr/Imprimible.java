package org.ggomezr;

public interface Imprimible {
    static void imprimir(Documento documento){
        System.out.println(documento.obtenerContenido());
    }
}
