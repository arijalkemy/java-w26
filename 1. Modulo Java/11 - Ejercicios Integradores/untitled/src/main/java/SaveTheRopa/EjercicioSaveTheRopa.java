package SaveTheRopa;

import SaveTheRopa.Clases.GuardaRopa;
import SaveTheRopa.Clases.Prenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class EjercicioSaveTheRopa
{
    public static void main( String[] args )
    {
        Prenda prendaUno = new Prenda("Tommy","camisa");
        Prenda prendaDos = new Prenda("Stanley","mate");

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(prendaUno);
        listaPrenda.add(prendaDos);


        guardaRopa.guardarPrendas(listaPrenda);

        guardaRopa.mostrarPendas();

        List<Prenda> prendaDevuelto = guardaRopa.devolverPrendas(1);

        System.out.print(prendaDevuelto);

    }
}
