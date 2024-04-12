package bootcamp.bendezujonathan;

import bootcamp.bendezujonathan.cliente.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(
                List.of(new Cliente("42", "Leo", "Perez"),
                        new Cliente("43", "Igna", "Colon")));

        clientes.forEach(System.out::println);

        clientes.remove((int) Math.random() * (clientes.size() - 1));
        clientes.forEach(System.out::println);

        Scanner out = new Scanner(System.in);
        System.out.println(">> Ingrese el numero de documento del usuario: ");
        String dni = out.next();
        out.close();

        clientes.stream()
                .filter(x -> x.getDni()
                        .equals(dni.trim()))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No se encontró el cliente a buscar."));

    }

}
