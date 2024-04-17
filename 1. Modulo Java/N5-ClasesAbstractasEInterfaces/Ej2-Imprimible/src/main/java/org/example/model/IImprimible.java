package org.example.model;

public interface IImprimible {

    // Al ser un método estático, puedo usarlo sin implementar la interfaz
    static void imprimir(Documento documento) {
        System.out.println(documento.obtenerContenido());
    }
}
