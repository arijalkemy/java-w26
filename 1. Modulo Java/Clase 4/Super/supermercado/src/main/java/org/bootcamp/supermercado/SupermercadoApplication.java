package org.bootcamp.supermercado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SupermercadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermercadoApplication.class, args);

        //PARTE 1
        Cliente cliente1 = new Cliente(12345678, "Juan", "Pérez");
        Cliente cliente2 = new Cliente(87654321, "María", "López");
        Cliente cliente3 = new Cliente(11223344, "Carlos", "González");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);

        clientes.remove(cliente1);
        clientes.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un DNI para buscarlo en la lista ");
        long dni= scanner.nextLong();
        Cliente clienteEncontrado= null;
        for(Cliente cliente : clientes) {
            if(cliente.getDni() == dni) {
                clienteEncontrado = cliente;
            }
        }
        if(clienteEncontrado!= null) {
            System.out.println(clienteEncontrado.toString());
        }else{
            System.out.println("no existe el cliente con el DNI " + dni);
        }





    }

}
