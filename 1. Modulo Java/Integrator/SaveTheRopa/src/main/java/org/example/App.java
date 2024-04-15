package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Prenda camiseta = new Prenda("Zara", "Camiseta Hombre");
        Prenda pantalon = new Prenda("Levis", "Jean Hombre");

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> ropaNicolas = new ArrayList(){{add(camiseta); add(pantalon);}};
        guardaRopa.guardarPrendas(1, ropaNicolas);
        List<Prenda> ropaJohan = new ArrayList(){{add(camiseta);}};
        guardaRopa.guardarPrendas(2, ropaJohan);

        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(1);
        guardaRopa.mostrarPrendas();

        guardaRopa.guardarPrendas(2, ropaNicolas);
        guardaRopa.mostrarPrendas();

    }
}
