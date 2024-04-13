package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Prenda prenda1 = new Prenda("SUPREME","Linda ropa");
        Prenda prenda2 = new Prenda("NIKE", "Zapatillas deportivas");

        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        GuardarRopa guardarRopa = new GuardarRopa();
        Integer key = guardarRopa.guardarPrendas(listaDePrendas);
        System.out.println(guardarRopa.devolverPrendas(key));
    }
}
