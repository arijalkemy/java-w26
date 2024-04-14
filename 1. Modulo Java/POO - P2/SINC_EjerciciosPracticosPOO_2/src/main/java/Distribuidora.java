import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        //Creo objetos de tipos perecedero y no perecedero, ambos derivan de la clase producto
        Producto producto1 = new Perecedero("Pan", 150, 2);
        Producto producto2 = new Perecedero("Carne", 1300, 10);
        Producto producto3 = new NoPerecedero("Atun", 540, "No vegetariano");
        Producto producto4 = new NoPerecedero("Galletas", 300, "Vegano");
        Producto producto5 = new NoPerecedero("Cereales", 780, "Vegano");

        //Creo una lista de los objetos creados
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        //Agrego los objetos creados a la lista
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        listaProductos.add(producto5);

        //Recorro la lista mostrando los atributos de cada objeto (haciendo uso de polimorfismo del metodo toString)
        for (Producto prod : listaProductos) {
            System.out.println(prod.toString());
        }
    }
}
