package com.bootcamp.documentos;

public interface DocumentoImprimible {
     static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }
}
