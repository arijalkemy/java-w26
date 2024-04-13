package SerieNumerica;

public class MainSeries {
    public static void main(String[] args) {

        SerieEntera serieEntera = new SerieEntera(2);

        serieEntera.imprimirSerie(4);

        System.out.println("------------");

        serieEntera.valorInicial(1);
        serieEntera.imprimirSerie(4);

        System.out.println("------------");

        SerieDecimal serieDecimal = new SerieDecimal(2.0);

        serieDecimal.imprimirSerie(4);
    }
}
