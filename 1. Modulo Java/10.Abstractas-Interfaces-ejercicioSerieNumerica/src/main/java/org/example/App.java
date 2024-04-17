package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Integer uno = 6;
        Integer dos = 2;

        Integer resultado  = uno+dos;
        System.out.println(resultado);

        SerieUno s1 = new SerieUno();
        SerieDos s2 = new SerieDos();

        System.out.println("SERIE UNO DE 2 EN 2 INICIANDO EN 0");
        s1.valorInicial(0);
        s1.valorSiguiente();
        s1.valorSiguiente();
        s1.valorSiguiente();
        s1.valorSiguiente();
        System.out.println();

        System.out.println("SERIE UNO DE 2 EN 2 INICIANDO EN 1");
        s1.valorInicial(1);
        s1.valorSiguiente();
        s1.valorSiguiente();
        s1.valorSiguiente();
        s1.valorSiguiente();
        System.out.println();

        System.out.println("SERIE DOS DE 3 EN 3 INICIANDO EN 0");
        s2.valorInicial(0);
        s2.valorSiguiente();
        s2.valorSiguiente();
        s2.valorSiguiente();
        s2.valorSiguiente();


    }
}
