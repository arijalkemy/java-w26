package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cliente cliente1 = new Cliente("Maca Caridad", "34567890", "Av. Gral Paz 125");
        Cliente cliente2 = new Cliente("Paz Pereira", "12345678", "La Paz 546");
        Cliente cliente3 = new Cliente("Maxi Molina", "23098765", "Pampayasta 3456");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        System.out.println("Lista completa");
        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        clientes.remove(cliente1);

        System.out.println("Lista sin el primer cliente");
        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.println("Ingrese un dni");
        Scanner scanner = new Scanner(System.in);
        String dniXConsola = scanner.next();

        Optional<Cliente> encontrado = clientes.stream().filter(c -> c.getDni().equals(dniXConsola)).findFirst();
        if(encontrado.isPresent()){
            System.out.println(encontrado.get());
        } else {
            System.out.println("No se encontró el cliente");
        }
    }
}
