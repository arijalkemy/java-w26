package org.bootcamp.service.impl;

import org.bootcamp.domain.Informe;
import org.bootcamp.service.Imprimible;

public class InformeImpresion implements Imprimible<Informe> {
    @Override
    public void imprimir(Informe documento) {
        System.out.println(documento.toString());
    }
}
