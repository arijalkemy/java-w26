package org.example;

import java.security.Guard;
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
        Prenda pantalon = new Prenda("zarasa", "cargo");
        Prenda zapatillas = new Prenda("adidas", "deportivas");

        List<Prenda> prendasParaGuardar = new ArrayList<>();

        prendasParaGuardar.add(pantalon);
        prendasParaGuardar.add(zapatillas);

        Guardarropa guardarropa = new Guardarropa();
        Integer codigo = guardarropa.guardarPrendas(prendasParaGuardar);

        List<Prenda> prendasParaMostrar = guardarropa.devolverPrendas(codigo);
        System.out.println(prendasParaMostrar);

        guardarropa.mostrarPrendas();

    }
}
