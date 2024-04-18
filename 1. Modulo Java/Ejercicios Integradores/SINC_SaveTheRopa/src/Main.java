import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Prenda pantalon = new Prenda("Pantalon", "Adidas", "Deportivo");
        Prenda remera = new Prenda("Remera", "Nike", "Running");

        GuardaRopa guardaRopa = new GuardaRopa();

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Guardar las prendas (pantalon y remera) en el guardarropa");
            System.out.println("2. Mostrar todas las prendas en el guardarropa junto con su identificador");
            System.out.println("3. Mostrar todas las prendas dado un identificador");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    int identificadorAsignado = guardaRopa.guardarPrendas(List.of(pantalon, remera));
                    System.out.println("\nSe le asigno el identificador numero " + identificadorAsignado);
                    break;
                case 2:
                    System.out.println("");
                    guardaRopa.mostrarPrendas();
                    break;
                case 3:
                    System.out.print("\nIngrese el numero de identificador: ");
                    int numero = teclado.nextInt();
                    guardaRopa.devolverPrendas(numero);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
                    break;
            }
        } while (opcion != 4);
    }
}