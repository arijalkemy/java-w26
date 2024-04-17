package org.example;

class Flotantes extends SerieNumerica<Float> {
    private float paso;

    public Flotantes(float valorInicial, float paso) {
        super(valorInicial);
        this.paso = paso;
    }

    @Override
    public Float valorSiguiente() {
        float siguiente = valorActual + paso;
        valorActual = siguiente;
        return siguiente;
    }
}

