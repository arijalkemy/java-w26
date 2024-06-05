package org.example;

import org.example.logica.GuardaRopa;
import org.example.logica.Prenda;
import org.example.logica.PrendaChaleco;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App

{   //reciba el código y luego consulta por sus prendas guardadas.
    public static void main( String[] args )
    {
        //1)Creacion de dos prendas
        Prenda prenda_chaleco = new PrendaChaleco("Levis", "Modelo 1", "Jean", "M");
        Prenda prenda_pantalon = new PrendaChaleco("Levis", "Modelo 1", "Jean", "38");

        //2) Creacion y guardado de prendas
        GuardaRopa guarda_ropa = new GuardaRopa();

        //3) Creacion de la lista
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda_chaleco);
        prendas.add(prenda_pantalon);

        //4) Asignacion del guardaropa
        Integer clave = guarda_ropa.guardarPrenda(prendas);

        //5)Mostrar prendas
        guarda_ropa.devolverPrenda(clave).stream().forEach(System.out::println);





    }

}
