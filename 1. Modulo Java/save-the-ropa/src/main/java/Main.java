import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prendaUno = new Prenda("Tommy","camisa");
        Prenda prendaDos = new Prenda("Adidas","buzo");

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(prendaUno);
        listaPrenda.add(prendaDos);

        guardaRopa.guardarPrendas(listaPrenda);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendaDevuelto = guardaRopa.devolverPrendas(1);

        System.out.print(prendaDevuelto);
    }
}
