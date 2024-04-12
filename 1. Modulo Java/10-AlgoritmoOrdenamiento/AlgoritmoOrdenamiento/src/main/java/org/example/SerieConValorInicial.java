package org.example;

public class SerieConValorInicial extends Prototipo {
    @Override
    public Number siguienteNumero(Integer anterior) {
        return this.getValorInicial().doubleValue()+2;
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void numeroInicial(Number inicial) {
        super.numeroInicial(inicial);
    }
}
