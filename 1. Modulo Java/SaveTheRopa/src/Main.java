import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardarropa guardarropa = new Guardarropa();

        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        Prenda prenda3 = new Prenda("Puma", "Zapatos");

        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda2);

        List<Prenda> lista2 = new ArrayList<>();
        lista2.add(prenda3);

        Integer id1 = guardarropa.guardarPrendas(lista1);
        Integer id2 = guardarropa.guardarPrendas(lista2);

        System.out.println("-----");
        guardarropa.mostrarPrendas();
    }
}