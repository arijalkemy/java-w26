import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Prenda zapatillas = new Prenda("Nike","Zapatillas");
        Prenda campera = new Prenda("Adidas","Campera");

        List<Prenda> listPrendas = new ArrayList<>();
        listPrendas.add(zapatillas);
        listPrendas.add(campera);

        GuardarRopa guardaRopa = new GuardarRopa();


        Integer codigo = guardaRopa.guardarPrendas(listPrendas);

        System.out.println("Id de guarda ropa: "+codigo);

        List<Prenda> listPrendaDevuelta = guardaRopa.devolverPrendas(codigo);

        System.out.println(listPrendaDevuelta.toString());


    }
}