package org.bootcamp.service.impl;

import org.bootcamp.domain.CV;
import org.bootcamp.service.Imprimible;

public class CVImpresion implements Imprimible<CV> {
    @Override
    public void imprimir(CV documento) {
        System.out.println(documento.toString());
    }
}
