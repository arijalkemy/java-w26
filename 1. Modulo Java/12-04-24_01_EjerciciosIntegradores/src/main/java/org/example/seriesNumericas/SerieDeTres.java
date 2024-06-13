package org.example.seriesNumericas;

public class SerieDeTres extends SerieProgresiva<Integer> {
    public SerieDeTres() {
        super(3);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
