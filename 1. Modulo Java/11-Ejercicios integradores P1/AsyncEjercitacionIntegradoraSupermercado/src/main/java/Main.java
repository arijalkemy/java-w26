import Model.Client;
import Repository.ClientImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClientImplementation clientImplementation = new ClientImplementation();

        // Carga de clientes
        Client firstClient = new Client(42722377L, "Bruno", "Donato");
        Client secondClient = new Client(42722378L, "Joaquin", "Rodriguez");
        Client thirdClient = new Client(42722379L, "Mateo", "Rios");

        // Carga de los clientes a la lista
        clientImplementation.save(firstClient);
        clientImplementation.save(secondClient);
        clientImplementation.save(thirdClient);

        // Mostrar todos los clientes
        clientImplementation.showScreen();

        // Busqueda de un cliente
        clientImplementation.loockFor(42722378L);

        // Leer dni a buscar para eliminar
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el dni para eliminar");
        Long dniToDelete = keyboard.nextLong();
        clientImplementation.delete(dniToDelete);

    }
}
