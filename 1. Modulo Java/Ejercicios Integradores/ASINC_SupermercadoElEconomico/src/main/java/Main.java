import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        //Punto 2: Creo tres clientes y los agrego a una coleccion
        Cliente cliente1 = new Cliente("Marcos", "Ditta", "42052682");
        Cliente cliente2 = new Cliente("Ignacio", "Granthon", "56483294");
        Cliente cliente3 = new Cliente("Bautista", "Granthon", "45382943");

        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        //Parte 2
        Item item1 = new Item(1, "Atun", 2, 15);
        Item item2 = new Item(2, "Fideos", 1, 40);
        Item item3 = new Item(3, "Gaseosa", 3, 100);

        Factura factura = new Factura(cliente1, List.of(item1, item2, item3));
        factura.calcularCostoTotalCompra();

        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar los datos de todos los clientes en la coleccion");
            System.out.println("2. Eliminar un cliente de la coleccion ingresando su DNI");
            System.out.println("3. Mostrar datos de un cliente ingresando su DNI");
            System.out.println("4. Mostrar datos de la factura");
            System.out.println("9. Salir");
            System.out.print("\nIngrese una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    //Punto 3: Muestro los datos de los clientes que estan en la coleccion
                    System.out.println("\nListado de clientes en la coleccion:");
                    for (Cliente cli : listaClientes ) {
                        System.out.println(cli.toString());}
                    break;
                case 2:
                    //Punto 4: Solicito dni por consola para eliminarlo de la coleccion
                    System.out.print("\nIngrese el dni del cliente a eliminar de la coleccion: ");
                    String dniIngresado = teclado.next();

                    Cliente clienteAEliminar = listaClientes.stream()
                            .filter(x -> x.getDni().equals(dniIngresado))
                            .findFirst()
                            .orElse(null);

                    if (clienteAEliminar != null) {
                        //borra el cliente de la coleccion
                        listaClientes.remove(clienteAEliminar);
                        System.out.println("El cliente fue removido de la coleccion, quedando la misma de esta forma:");
                        for (Cliente cli : listaClientes ) {
                            System.out.println(cli.toString());
                        }
                    } else {
                        System.out.println("El DNI ingresado no corresponde a un cliente\n");
                    }
                    break;
                case 3:
                    //Punto 5: Solicito dni por consola para mostrar sus datos
                    System.out.print("\nIngrese el dni del cliente a consultar: ");
                    dniIngresado = teclado.next();

                    Cliente clienteAMostrar = listaClientes.stream()
                            .filter(x -> x.getDni().equals(dniIngresado))
                            .findFirst()
                            .orElse(null);

                    if (clienteAMostrar != null) {
                        System.out.println("\nDatos del cliente:");
                        System.out.println(clienteAMostrar.toString());
                    } else {
                        System.out.println("El dni ingresado no corresponde a un cliente");
                    }
                    break;
                case 4:
                    System.out.println("\nCliente: " + factura.getCliente().getNombre());
                    for (Item item : factura.getListaItems()) {
                        System.out.println(item.getNombre() + " - costo unitario: " + item.getCostoUnitario() +
                                " - cantidad: " + item.getCantidad());
                    }
                    System.out.println("El monto total de la compra es: " + factura.getCostoTotalCompra());
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Esa opcion no es valida");
            }
        } while (opcion != 9);
    }
}
