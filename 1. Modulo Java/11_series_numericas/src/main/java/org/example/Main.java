package org.example;

public class Main {
    public static void main(String[] args) {

        SerieNumericaDouble serieDouble = new SerieNumericaDouble();
        serieDouble.setInitialValue(2.0);
        System.out.println(serieDouble.getNextNumber());
        System.out.println(serieDouble.getNextNumber());
        System.out.println(serieDouble.getNextNumber());
        System.out.println("-------");

        SerieNumericaInteger serieInteger = new SerieNumericaInteger();
        serieInteger.setInitialValue(5);
        System.out.println(serieInteger.getNextNumber());
        System.out.println(serieInteger.getNextNumber());
        System.out.println(serieInteger.getNextNumber());
        System.out.println("-------");
    }
}