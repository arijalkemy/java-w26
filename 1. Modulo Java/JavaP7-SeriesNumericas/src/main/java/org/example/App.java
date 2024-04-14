package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Serie2 serie2 = new Serie2();
        Serie3 serie3 = new Serie3();


        System.out.println("Serie 2");
        serie2.setValorInicial(6);
        System.out.println(serie2.getValorInicial());
        System.out.println(serie2.regresaSiguienteValor());
        System.out.println(serie2.regresaSiguienteValor());
        System.out.println(serie2.regresaSiguienteValor());
        serie2.reiniciarSerie();
        System.out.println(serie2.getValorInicial());
        System.out.println(serie2.regresaSiguienteValor());
        System.out.println(serie2.regresaSiguienteValor());


        System.out.println("Serie 3");
        serie3.setValorInicial(Float.valueOf((float) 7.754 ));
        System.out.println(serie3.getValorInicial());
        System.out.println(serie3.regresaSiguienteValor());
        System.out.println(serie3.regresaSiguienteValor());
        System.out.println(serie3.regresaSiguienteValor());
        serie3.reiniciarSerie();
        System.out.println(serie3.getValorInicial());
        System.out.println(serie3.regresaSiguienteValor());
        System.out.println(serie3.regresaSiguienteValor());

    }
}
