package org.example;

public abstract class Prototipo {
    protected int numberInit;

    public Prototipo(int numberInit) {
        this.numberInit = numberInit;
    }


    public abstract int nextNumber();

    public int resetList() {
        return numberInit = 0;
    }

    public void initList(int numeroInicial){
        numberInit = numeroInicial;
    }
}
