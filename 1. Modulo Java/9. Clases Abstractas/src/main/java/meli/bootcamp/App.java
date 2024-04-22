package meli.bootcamp;

public class App {
  public static void main(String[] args) {
    SerieNumericaDeEnteros serie = new SerieNumericaDeEnteros(0, 2);

    System.out.println(serie.siguienteValor());
    System.out.println(serie.siguienteValor());
    System.out.println(serie.siguienteValor());

    serie.setValorInicial(10);
    System.out.println(serie.siguienteValor());
    System.out.println(serie.siguienteValor());
    System.out.println(serie.siguienteValor());

    serie.reiniciarSerie();
    System.out.println(serie.siguienteValor());
  }
}
