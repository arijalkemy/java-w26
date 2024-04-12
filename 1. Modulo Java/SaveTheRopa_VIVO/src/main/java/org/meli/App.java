package org.meli;
import org.meli.clases.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(new Prenda("Nike", "Zapatillas"));
        listaDePrendas.add(new Prenda("Adidas", "Zapatillas"));
        listaDePrendas.add(new Prenda("Puma", "Zapatillas"));

        Integer identificador1 = guardaRopa.guardarPrendas(listaDePrendas);

        List<Prenda> listaDePrendas2 = new ArrayList<>();
        listaDePrendas2.add(new Prenda("Nike", "Camisa"));
        listaDePrendas2.add(new Prenda("Adidas", "Buso"));
        listaDePrendas2.add(new Prenda("Adidas", "Zapatillas"));

        Integer identificador2 = guardaRopa.guardarPrendas(listaDePrendas2);

        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(identificador1);

        System.out.println("DESPUES DE DEVOLVER");
        System.out.println("*******************");
        guardaRopa.mostrarPrendas();

    }
}
