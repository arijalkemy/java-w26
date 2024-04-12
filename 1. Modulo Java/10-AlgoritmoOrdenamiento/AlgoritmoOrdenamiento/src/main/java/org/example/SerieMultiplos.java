package org.example;

public class SerieMultiplos extends Prototipo {
    @Override
    public Integer siguienteNumero(Integer anterior) {
        Number result = anterior*this.getValorInicial().intValue();
        return result.intValue();
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void numeroInicial(Number inicial) {
        super.numeroInicial(inicial);
    }
}
