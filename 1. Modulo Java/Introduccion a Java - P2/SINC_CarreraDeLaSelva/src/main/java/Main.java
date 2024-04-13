import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Categorias categoria1 = new Categorias(1, "Circuito chico", "2 km por selva y arroyos");
        Categorias categoria2 = new Categorias(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categorias categoria3 = new Categorias(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Participantes participante1 = new Participantes(1, "42052682", "Marcos", "Ditta", 24, 351566888, 351233233, "A+");
        Participantes participante2 = new Participantes(2, "45069582", "Alexis", "Diaz", 16, 356786514, 354728509, "AB+");
        Participantes participante3 = new Participantes(3, "19767823", "Ignacio", "Granthon", 43, 354633274, 351434453, "A+");

        Inscripciones inscripcion1 = new Inscripciones(1, categoria2, participante1);
        Inscripciones inscripcion2 = new Inscripciones(2, categoria2, participante2);
        Inscripciones inscripcion3 = new Inscripciones(3, categoria3, participante3);

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n- MENU -");
            System.out.println("1. Calcular el monto de la inscripcion a partir de un DNI (Ejemplo 42052682)");
            System.out.println("2. Mostrar inscriptos a una determinada categoria (Id categorais: 1, 2, 3)");
            System.out.println("3. Desincribir a un participante a partir de su DNI y mostrar la categoria donde estaba");
            System.out.println("4. Mostrar los montos totales por categoria y monto total de todas las categorias");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            System.out.print("\n");

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un DNI: ");
                    String dniIngresado = teclado.next();
                    System.out.println(Inscripciones.calcularMontoPorDNI(dniIngresado));
                    break;
                case 2:
                    System.out.print("Ingrese un ID de categoria: ");
                    int catIngresada = teclado.nextInt();
                    System.out.println("\n- INSCRIPCIONES ENCONTRADAS PARA LA CATEGORIA " + catIngresada + " -");
                    for (Inscripciones inscripcion : Inscripciones.obtenerInscripcionesPorCategoria(catIngresada)) {
                        System.out.println(inscripcion.mostrarDatosInscripcion());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese un DNI: ");
                    dniIngresado = teclado.next();
                    int idCategoria = Inscripciones.obtenerCategoria(dniIngresado);

                    Inscripciones.desincribirParticipante(dniIngresado);

                    System.out.println("\n- INSCRIPCIONES QUE QUEDARON EN LA CATEGORIA " + idCategoria + " -");
                    for (Inscripciones inscripcion : Inscripciones.obtenerInscripcionesPorCategoria(idCategoria)) {
                        System.out.println(inscripcion.mostrarDatosInscripcion());
                    }
                    break;
                case 4:
                    System.out.println("Monto total categoria 1: " + Inscripciones.obtenerMontosTotales(1));
                    System.out.println("Monto total categoria 2: " + Inscripciones.obtenerMontosTotales(2));
                    System.out.println("Monto total categoria 3: " + Inscripciones.obtenerMontosTotales(3));
                    System.out.println("Monto total: " + Inscripciones.obtenerMontosTotales(0));
                break;

                case 5:
                    System.out.print("Saliendo...");
                break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 5);
    }
}
