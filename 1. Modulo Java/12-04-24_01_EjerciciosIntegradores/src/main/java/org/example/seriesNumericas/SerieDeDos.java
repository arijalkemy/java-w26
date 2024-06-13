package org.example.seriesNumericas;

public class SerieDeDos extends SerieProgresiva<Integer> {
    public SerieDeDos() {
        super(2);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
