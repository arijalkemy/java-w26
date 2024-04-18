package distribuidora.parte2;

import org.example.PracticaExcepciones;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {


        //Creo Productos perecederos
        Producto manzana = new Perecedero("Manzana", 10.5, 1);
        Producto pera = new Perecedero("Pera", 10, 2);
        Producto leche = new Perecedero("Leche", 60, 3);
        Producto ciruela = new Perecedero("Ciruela", 20, 2);
        Producto crema = new Perecedero("Crema", 50, 2);

        //Creo productos No perecederos
        Producto arroz = new NoPerecedero("Arroz", 20, "legumbres");
        Producto lentejas = new NoPerecedero("Lentejas", 30, "legumbres");
        Producto lechePolvo = new NoPerecedero("Leche en polvo", 100, "lacteos");
        Producto arvejas = new NoPerecedero("Arvejas", 10, "legumbres");
        Producto miel = new NoPerecedero("Miel", 30, "dulces");



        //Creo lista de productos
        ArrayList <Producto> productos = new ArrayList<>();

        //Agrego productos a la lista
        productos.add(manzana);
        productos.add(leche);
        productos.add(pera);
        productos.add(ciruela);
        productos.add(crema);
        productos.add(arroz);
        productos.add(lentejas);
        productos.add(lechePolvo);
        productos.add(arvejas);
        productos.add(miel);


        //Muestro ticket de compra
        mostrarTicket(productos);
    }
    public static void mostrarTicket(ArrayList<Producto> listaProductos){
        //creo variable para total de venta
        double totalVenta = 0;


        //Creacion del ticket
        System.out.println("***********************");
        System.out.println("Bienvenido a Distribuidora Joita");
        System.out.println("***********************");
        System.out.println("Precios individuales por producto");
        System.out.println("_________________________________");
        //Recorro lista para calcular el valor por producto y acumular el valor total
        for (int i = 0; i < listaProductos.size() ; i++) {
            double totalXProducto = listaProductos.get(i).calcular(5);
            System.out.println(listaProductos.get(i).getNombre() + "\n$" + totalXProducto + "\n");
            totalVenta += totalXProducto;
        }
        System.out.println("_________________________________");
        System.out.println("Total: \n" + totalVenta );
        System.out.println("_________________________________");
        System.out.println("Gracias por su compra!");
        //Final del ticket
    }
}
