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
        // Creando Prendas
        Prenda camisa = new Prenda("Lacoste","L1212");
        Prenda pantalon = new Prenda("Lacoste","7-75123");
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(camisa);
        prendas.add(pantalon);

        // Creando Guarda Ropa
        GuardaRopa gr = new GuardaRopa();

        // Guardar Prendas
        Integer identificador = gr.guardarPrendas(prendas);

        System.out.println("Se guardaron las prendas Con el identificador: "+ identificador);

        gr.mostrarPrendas();

    }
}
