import NoPerecedero.NoPerecedero;
import Perecedero.Perecedero;
import Producto.Producto;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];

        // llenar array
        for(int i = 0; i < productos.length; i++){
            if(i<5){
                productos[i] = new Perecedero("Producto Perecedero", (i + 100) + 200, i%5);
            } else {
                productos[i] = new NoPerecedero("Producto No Perecedero", (i + 100) + 200, "No Perecedero");
            }
        }

        double total = 0;

        // calcular el total de "vender" todos los productos
        for(int i = 0; i<productos.length; i++){
            total = total + productos[i].calcular(i + 5);
        }

        // imprimir el resultado
        System.out.println("TOTAL: " + total);

    }
}
