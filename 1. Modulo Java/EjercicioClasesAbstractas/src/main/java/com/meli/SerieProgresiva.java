package com.meli;

public class SerieProgresiva {
    protected Number valorActual;
    protected Number paso;

    public SerieProgresiva(Number paso) {
        this.paso = paso;
        reiniciarSerie();
    }

    public Number valorSiguiente() {
        valorActual = sumar(valorActual, paso);
        return valorActual;
    }

    public void reiniciarSerie() {
        valorActual = 0; // Cambiar según el tipo de dato numérico no primitivo
    }

    public void establecerValorInicial(Number valorInicial) {
        valorActual = valorInicial;
    }

    private Number sumar(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a + (Integer) b;
        } else if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        }
        return null;
    }
}
