package org.example;

public class Serie extends Prototipo{
    public Serie() {
        super(0);
    }

    @Override
    public int nextNumber() {
         numberInit+=2;
         return numberInit;
    }

}
