package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("44195957", "Franco", "Moises"),
                new Cliente("44195956", "Candelaria", "Garcia"),
                new Cliente("44195955", "Elian", "Moises")
        ));
        List<Factura> facturas = new ArrayList<>();
        clientes.forEach(System.out::println);
        clientes.remove(1);
        clientes.forEach(System.out::println);

        System.out.println("Ingrese el DNI del cliente: ");
        Scanner scn = new Scanner(System.in);
        String dniInput = scn.next().trim();
        //Busco e imprimo el cliente con el dni ingresado
        //Si no se encuentra, imprimo "no se encontró el cliente"
        clientes.stream()
                .filter((c) -> c.getDni().equals(dniInput))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No se encontró el cliente"));


        List<Item> items = new ArrayList<>(List.of(
                new Item("AA-100", "Lija al Agua", 3, 2500),
                new Item("AA-120", "Lija al Agua", 6, 3500)
        ));
        double total = items.stream()
                .mapToDouble((i) -> i.getCostoUnitario() * i.getCantidad())
                .sum();
        Factura factura = new Factura(new Cliente("44195957", "Franco", "Moises"), items, total);

        if (!clientes.stream().anyMatch(c -> c.getDni() == factura.getCliente().getDni())) {
            clientes.add(factura.getCliente());
        }
        facturas.add(factura);

    }
}
