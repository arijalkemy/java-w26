
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);
        Perecedero[] productosPerecederos = new Perecedero[5];
        NoPerecedero[] productosNoPerecederos = new NoPerecedero[5];

        productosPerecederos[0] = new Perecedero("Manzana",250,1);
        productosPerecederos[1] = new Perecedero("Banana",300,2);
        productosPerecederos[2] = new Perecedero("Melon",11.1,3);
        productosPerecederos[3] = new Perecedero("Sandia",200,4);
        productosPerecederos[4] = new Perecedero("Uva",33,10);
        System.out.println(productosPerecederos.length);

        double total = 0;
        for (int i = 0; i<5;i++){
            System.out.println(productosPerecederos[i].toString());
            System.out.println("Ingrese la cantidad: ");
            int cantidad = input.nextInt();
            total += productosPerecederos[i].calcular(cantidad);
        }
        System.out.println(total);
    }
}