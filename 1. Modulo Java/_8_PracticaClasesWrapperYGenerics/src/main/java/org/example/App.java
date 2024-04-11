package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int valorprimitivo = 223;
        Integer valor = Integer.valueOf(valorprimitivo);

        String valorString = "223";
        System.out.println(Integer.valueOf(valorString));

        System.out.println(valor);

        //Colecciones con generics
        ArrayList<String> aS = new ArrayList<>();
        aS.add("marcos");
        aS.add("pedro");
        aS.add("Juan");
        aS.add("Jorge");
        aS.add("roberto");


        //aplicacion de STREAMS
        System.out.println("Recorro la lista con un stream: ");
        aS.stream().forEach(System.out::println);

        //hago que esten todos con mayuscula
        System.out.println("Ahora en mayuscula: ");
        aS.stream().map(nombre -> nombre.toUpperCase()).forEach(System.out::println);

        //lo hago upper pero los guardo
        System.out.println("Ahora en una nueva lista y en minuscula: ");
        List<String> nuevaLista = aS.stream().map(nombre -> nombre.toLowerCase()).collect(Collectors.toList());
        nuevaLista.stream().forEach(System.out::println);

        //ahora streams con int
        Integer[] numerosArray = {1,2,3,4,7};
        System.out.println("Mostrar solo los numeros mayores a 5 ");
        List<Integer> numeros = Arrays.asList(numerosArray);
        numeros.stream().filter(numero -> numero >= 5).forEach(System.out::println);

        Integer resultado = numeros.stream().mapToInt(numero -> numero).sum();
        System.out.println("El resultado de la suma es: " + resultado);


        //clase abstracta
        SonOfAbstract claseHija = new SonOfAbstract(332);
        System.out.println("El resultado del calculo es: " + Math.round(claseHija.calcular()));
        System.out.println("Metodo comun: " + claseHija.metodoComun());

        ICalculo calculo = claseHija;
        System.out.println("El resultado del calculo es: " + calculo.calcularBien());
    }
}
