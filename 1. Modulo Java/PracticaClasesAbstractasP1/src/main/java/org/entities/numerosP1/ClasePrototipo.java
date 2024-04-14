package org.entities.numerosP1;

public abstract class ClasePrototipo<T extends Number> {
    private T inicioSerie;
    private T actual;

    public ClasePrototipo(T inicioSerie) {
        this.inicioSerie = inicioSerie;
        this.actual = inicioSerie;
    }


    public T getInicioSerie() {
        return inicioSerie;
    }

    public T getActual() {
        return actual;
    }

    public void setActual(T actual) {
        this.actual = actual;
    }

    public void reiniciarSerie() {
        this.actual = this.inicioSerie;
        System.out.println("Serie reiniciada a " + this.inicioSerie);
    }

    public abstract T siguienteNumero();

    public void establecerNumeroInicial(T num) {
        this.inicioSerie = num;
        this.actual = this.inicioSerie;
        System.out.println("Inicio de serie establecido en " + this.inicioSerie);
    }
}
