package bootcamp.bendezujonathan;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Prenda p1 = new Prenda("Gucci", "Pantalon");
        Prenda p2 = new Prenda("Vans", "Zapatillas");

        List<Prenda> prendas = List.of(p1, p2);

        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(prendas);
        guardaRopa.devolverPrendas(codigo)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No Existe el codigo de prendas proporcionado."));

    }
}