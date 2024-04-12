package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieUno serieUno = new SerieUno();
        for (int i = 0; i < 5; i++) {
            Integer resultado = serieUno.devolverSerie(2);
            System.out.println(resultado);
        }

        serieUno.establecerValorInicial(1);
        for (int i = 0; i < 5; i++) {
            Integer resultado = serieUno.devolverSerie(2);
            System.out.println(resultado);
        }


    }
}
