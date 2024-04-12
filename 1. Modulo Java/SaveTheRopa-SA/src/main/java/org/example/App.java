package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "--- Save the ropa ---" );
        Prenda prendaUno = new Prenda("Nike", "Polo");
        Prenda prendaDos = new Prenda("Adidas", "Pantalon");

        List<Prenda> listaDePrendas = List.of(prendaUno, prendaDos);

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigoDePrenda = guardaRopa.guardarPrendas(listaDePrendas);

        System.out.println( "--- Guarda ropa completo ---" );
        guardaRopa.mostrarPrendas();

        System.out.println( "--- Devolver prendas segun codigo ---" );
        List<Prenda> prendasEncontradas = guardaRopa.devolverPrendas(codigoDePrenda);
        for (Prenda prenda: prendasEncontradas){
            System.out.println("Marca: " + prenda.getMarca() + " Modelo: " + prenda.getModelo());
        }
    }
}
