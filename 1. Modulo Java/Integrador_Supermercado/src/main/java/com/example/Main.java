package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("123","Pedro","Perez"));
        clientes.add(new Cliente("456", "Juan", "Fernandez"));
        clientes.add(new Cliente("789", "Nicolas", "Colon"));

        //RECORRO TODOS LOS CLIENTES
        clientes.forEach(System.out::print);


        //ELIMINO UN CLIENTE
        clientes.remove((int) Math.random() * (clientes.size() - 1));  
        clientes.forEach(System.out::print);

        //BUSCAR UN CLIENTE
        Scanner out = new Scanner(System.in);
        System.out.println("Ingrese el numero de documento del usuario: ");
        String dni = out.next();
        out.close();

        clientes.stream()
            .filter(x -> x.getDni().equals(dni))
            .findFirst()
            .ifPresentOrElse(System.out::println, () -> System.out.println("No se encontró el cliente a buscar."));
    }
}