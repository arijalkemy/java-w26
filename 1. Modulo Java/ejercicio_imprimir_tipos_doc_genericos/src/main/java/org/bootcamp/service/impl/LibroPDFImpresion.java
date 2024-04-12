package org.bootcamp.service.impl;

import org.bootcamp.domain.LibroPDF;
import org.bootcamp.service.Imprimible;

public class LibroPDFImpresion implements Imprimible<LibroPDF> {
    @Override
    public void imprimir(LibroPDF documento) {
        System.out.println(documento.toString());
    }
}
