package org.example;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Guardar dos prendas y luego consultar por las prendas guardadas
        Prenda prenda1 = new Prenda("Nike", "Zapatillas", 1);
        Prenda prenda2 = new Prenda("Adidas", "Zapatillas", 2);
        Prenda prenda3 = new Prenda("Puma", "Zapatillas", 3);
        List<Prenda> prendas = List.of(prenda1, prenda2, prenda3);
        HashMap<Integer, Prenda[]> prendasMap = new HashMap<>();
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(prendas.toArray(new Prenda[0]));
        guardaRopa.mostrarPrendas();
    }
}
