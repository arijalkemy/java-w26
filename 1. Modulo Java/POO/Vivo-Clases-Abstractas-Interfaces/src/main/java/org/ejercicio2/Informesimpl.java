package org.ejercicio2;

public class Informesimpl implements IDocumento {
    private final Informes informe;

    public Informesimpl(Informes informe) {
        this.informe = informe;
    }

    @Override
    public void imprimir() {
        System.out.println(this.informe);
    }
}
