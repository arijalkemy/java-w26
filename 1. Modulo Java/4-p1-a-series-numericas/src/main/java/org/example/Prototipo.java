package org.example;

public class Prototipo <T extends Number> {

    private T valorInicial;
    private T valorActual;
    private T incremento;

    public Prototipo(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public T obtenerSiguiente() {
        T siguienteValor = valorActual;
        valorActual = sumar(valorActual, incremento); // Incrementar el valor actual
        return siguienteValor;
    }

    public void reiniciarSerie(T nuevoValorInicial) {
        this.valorInicial = nuevoValorInicial;
        this.valorActual = nuevoValorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public void setIncremento(T incremento) {
        this.incremento = incremento;
    }

    private T sumar(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Long || b instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
    }

}