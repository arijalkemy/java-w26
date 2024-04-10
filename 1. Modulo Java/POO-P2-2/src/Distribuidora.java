import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        //Creo intancias de producto de diferentes tipos.
        Producto productoUno = new Producto("ProductoUno", 10.0);
        Producto productoDos = new Perecedero("ProductoDos", 20.0, 2);
        Producto productoTres = new NoPerecedero("ProductoTres", 30.0, "Tipo");
        Producto productoCuatro = new NoPerecedero("ProductoCuatro", 40.0, "Tipo");
        Producto productoCinco = new Perecedero("ProductoCinco", 50.0, 1);

        //Intancio una lista de productos.
        List<Producto> listaDeProductos = new ArrayList<>();

        //Agrego los productos a la lista.
        listaDeProductos.add(productoUno);
        listaDeProductos.add(productoDos);
        listaDeProductos.add(productoTres);
        listaDeProductos.add(productoCuatro);
        listaDeProductos.add(productoCinco);

        //Calculo el precio total de la lista segun la cantidad de cada producto.
        int cantidadDeProductos = 5;
        double precioTotal = listaDeProductos.stream().mapToDouble(arr -> arr.calcular(cantidadDeProductos)).sum();

        //Muestro en consola el precio total.
        System.out.println("Precio total: " + precioTotal);
    }
}