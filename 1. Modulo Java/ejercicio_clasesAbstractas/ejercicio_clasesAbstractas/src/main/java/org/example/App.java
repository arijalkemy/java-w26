package org.example;

import org.example.classes.SerieDouble;
import org.example.classes.SerieInteger;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Integer> serie1 = new ArrayList<Integer>();
        SerieInteger serieInteger = new SerieInteger(serie1, 2);

        serieInteger.valorInicial(3);

        serieInteger.obtenerSiguiente();
        serieInteger.obtenerSiguiente();
        serieInteger.obtenerSiguiente();
        serieInteger.obtenerSiguiente();
        serieInteger.obtenerSiguiente();

        List<Double> serie2 = new ArrayList<Double>();
        SerieDouble serieDouble = new SerieDouble(serie2, 7D);

        serieDouble.valorInicial(4D);

        serieDouble.obtenerSiguiente();
        serieDouble.obtenerSiguiente();
        serieDouble.obtenerSiguiente();
        serieDouble.obtenerSiguiente();
        serieDouble.obtenerSiguiente();
    }
}
