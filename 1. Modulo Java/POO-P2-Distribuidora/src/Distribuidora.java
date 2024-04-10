import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Perecedero productoPercedero = new Perecedero("Tomate",20.5,2);
        NoPerecedero productoNoPercedero = new NoPerecedero("Arroz",50.5,"Blanco");
        productos.add(productoPercedero);
        productos.add(productoNoPercedero);

        for (Producto product : productos) {
            System.out.println(
                    product.getClass().getSimpleName()
                            .concat(" -> ")
                            .concat(product.getNombre())
                            .concat(" -> ")
                            .concat(String.valueOf(product.calcular(5)))
            );
        }
    }
}