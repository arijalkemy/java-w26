package bootcamp.bendezujonathan;

import java.util.stream.IntStream;

import bootcamp.bendezujonathan.abstractas.DoubleSerie;
import bootcamp.bendezujonathan.abstractas.IntSerie;

public class App {
    public static void main(String[] args) {
        showDouble();
        showInteger();
    }

    public static void showDouble() {
        DoubleSerie aSeries = new DoubleSerie(1D, 2D);
        IntStream.range(0, 10)
                .forEach(x -> System.out.println(aSeries.seguiente()));
    }
    public static void showInteger() {
        IntSerie aSeries = new IntSerie(1, 3);
        IntStream.range(0, 10)
                .forEach(x -> System.out.println(aSeries.seguiente()));
    }
}
