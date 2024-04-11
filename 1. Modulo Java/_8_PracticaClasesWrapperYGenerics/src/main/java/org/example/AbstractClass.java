package org.example;

public abstract class AbstractClass {
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public AbstractClass(int valor) {
        this.valor = valor;
    }

    public abstract double calcular();

    public int metodoComun(){
        return 23;
    }
}
