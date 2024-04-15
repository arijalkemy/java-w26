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
        GuardarRopa ropero = new GuardarRopa();
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add( new  Prenda("Arturo Calle","Camiseta"));
        prendas.add( new Prenda("Velez","Zapato"));

        int codigo = ropero.guardarPrendas(prendas);

        System.out.println(ropero.devolverPrendas(codigo));
        ropero.mostrarPrendas();

    }
}
