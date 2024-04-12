package org.example;

public class SonOfAbstract extends AbstractClass implements ICalculo{
    public SonOfAbstract(int valor) {
        super(valor);
    }

    public double calcular(){
        return 22/3.5;
    }

    @Override
    public double calcularBien() {
        return 23.4;
    }
}
