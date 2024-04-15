import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("1000", "Juan", "Perez"));
        clientes.add(new Cliente("1001", "Radamel", "Falcao"));
        clientes.add(new Cliente("1002", "Ayrton", "Senna"));

        clientes.forEach(System.out::println);

        clientes.remove(0);

        System.out.println("Despues del borrado");

        clientes.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        String clienteAConsultar = sc.nextLine();

        clientes.stream().filter(cliente -> cliente.getDni().equals(clienteAConsultar)).findFirst().ifPresentOrElse(
                System.out::println, () -> System.out.println("Cliente con ID " + clienteAConsultar +" No encontrado")
        );

        List<Item> items= new ArrayList<>();
        items.add(new Item("1","Atun",3,100));
        items.add(new Item("2","Perejil",2,230));

        Factura factura = new Factura(clientes.get(0),items,0);

        factura.setTotalCompra(factura.calcularCostos());

        System.out.println("Todal de la compra" + factura.getTotalCompra());

    }

}
