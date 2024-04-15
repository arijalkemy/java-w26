package EjerciciosIntegradores.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElEconomico elEconomico = new ElEconomico();

        agregarClientes(elEconomico);
        imprimirClientes(elEconomico);
        buscarCliente(elEconomico);
        crearItems(elEconomico);
        List<Item> items = crearItems(elEconomico);
        crearFactura(elEconomico, items);;
    }

    public static void agregarClientes(Supermercado supermercado){
        supermercado.agregarCliente(new Cliente(200000, "Pedro", "Pedrin"));
        supermercado.agregarCliente(new Cliente(211111, "Juan", "Pedron"));
        supermercado.agregarCliente(new Cliente(222222, "Ramon", "Pedrun"));
    }

    public static void imprimirClientes(Supermercado supermercado){
        supermercado.imprimirClientes();
        supermercado.quitarCliente(200000);
        supermercado.imprimirClientes();
    }

    public static void buscarCliente(Supermercado supermercado){
        System.out.println("Ingrese el DNI del cliente a buscar: ");
        supermercado.buscarCliente(new Scanner(System.in).nextInt());
    }

    public static List<Item> crearItems(Supermercado supermercado){
        List<Item> items = new ArrayList<>(){
            {
                add(new Item(1, "Picada", 1, 5000));
                add(new Item(1, "Fernet", 1, 7000));
                add(new Item(1, "Coca", 2, 3000));
            }
        };

        for(Item item : items){
            System.out.println(item);
        }

        return items;
    }

    public static void crearFactura(Supermercado supermercado, List<Item> items){
        supermercado.agregarFactura(211111, items);
    }
}