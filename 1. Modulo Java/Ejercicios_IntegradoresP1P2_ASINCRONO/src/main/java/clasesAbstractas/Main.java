package clasesAbstractas;

public class Main {
    public static void main(String[] args) {
        SerieProgresiva<Integer> serie = new SerieProgresivaInteger(2,2);
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());

        serie.setValorInicial(1);
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());

        SerieProgresiva<Double> serieDouble = new SerieProgresivaDoble(3.0, 3.0);
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
    }
}
