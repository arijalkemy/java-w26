import java.util.ArrayList;
import java.util.List;


public class Main
{
    public static void main( String[] args )
    {
        Clothing prendaUno = new Clothing("Tommy","camisa");
        Clothing prendaDos = new Clothing("Stanley","mate");

        Wardrobe guardaRopa = new Wardrobe();
        List<Clothing> listaPrenda = new ArrayList<>();
        listaPrenda.add(prendaUno);
        listaPrenda.add(prendaDos);

        guardaRopa.guardarPrendas(listaPrenda);

        guardaRopa.mostrarPendas();

        List<Clothing> prendaDevuelto = guardaRopa.devolverPrendas(1);

        System.out.print(prendaDevuelto);

    }
}
