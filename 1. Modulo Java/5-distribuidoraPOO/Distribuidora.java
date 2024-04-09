import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args){
        Perecedero[] productosPerecederos = new Perecedero[5];
        NoPerecedero[] productosNoPerecederos = new NoPerecedero[5];
        int numeroNoPerecederosGargados = 0;
        int numeroPerecederosGargados = 0;

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            System.out.println("Ingrese si el producto es perecedero (1) o no perecedero (2).");
            int numOpcion = teclado.nextInt();
            //filtra productos no perecederos con los que si
            if (numOpcion == 1){
                if (numeroPerecederosGargados == 5){
                    System.out.println("Lista completa, segui con los no perecederos.");
                    i--;
                }else {
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = teclado.next();
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = teclado.nextDouble();
                    System.out.println("Ingrese los dias hasta el vencimiento del producto: ");
                    int diasAVencer = teclado.nextInt();
                    Perecedero productoIngresar = new Perecedero(nombre, precio, diasAVencer);
                    productosPerecederos[numeroPerecederosGargados] = productoIngresar;
                }
                numeroPerecederosGargados++; // se suma 1 al contador de productos cargados
            }else{
                if (numeroNoPerecederosGargados == 5){
                    System.out.println("Lista completa, segui con los perecederos.");
                    i--;
                }else {
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = teclado.next();
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = teclado.nextDouble();
                    System.out.println("Ingrese el tipo del producto: ");
                    String tipo = teclado.next();
                    NoPerecedero productoIngresar = new NoPerecedero(nombre, precio, tipo);
                    productosNoPerecederos[numeroNoPerecederosGargados] = productoIngresar;
                }
                numeroNoPerecederosGargados++; //se suma 1 al contador de productos cargados
            }
        }
        double total = 0;

        for (int i=0; i < 5; i++){
            System.out.println(productosNoPerecederos[i].toString());
            System.out.println("Ingresa la cantidad:");
            int cantidad = teclado.nextInt();
            total += productosNoPerecederos[i].calcular(cantidad);
        }
        for (int i=0; i < 5; i++){
            System.out.println(productosPerecederos[i].toString());
            System.out.println("Ingresa la cantidad:");
            int cantidad = teclado.nextInt();
            total += productosPerecederos[i].calcular(cantidad);
        }
        teclado.close(); //se cierra el ingreso por teclado ya que no se utilizara mas

        System.out.println("El total es " + total);


    }
}
