package EjerciciosIntegradores.P1.ClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        SerieInt serie = new SerieInt();
        System.out.println(serie.comenzarSerie(2));
        System.out.println(serie.siguienteNumero());
        System.out.println(serie.siguienteNumero());
        System.out.println(serie.siguienteNumero());

        SerieDouble serieDouble = new SerieDouble();
        System.out.println(serieDouble.comenzarSerie(2.0));
        System.out.println(serieDouble.siguienteNumero());
        System.out.println(serieDouble.siguienteNumero());
        System.out.println(serieDouble.siguienteNumero());
    }
}
