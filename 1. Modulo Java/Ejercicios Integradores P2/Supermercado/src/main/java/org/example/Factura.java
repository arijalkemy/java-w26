package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    // El total de la compra se podria deducir de la suma del total de los items.
    // Pero como este valor no va a cambiar una vez emitida la factura, prefiero persistir este valor en el objeto Factura y no volver a calcularlo.
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = this.cargarItems();
        this.total = this.calcularTotal();
    }

    private double calcularTotal(){
        return this.items.stream().mapToDouble(Item::getTotal).sum();
    }

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    private List<Item> cargarItems(){
        List<Item> listaItems = new ArrayList<Item>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("- CARGA DE ITEM -");
        System.out.println("Ingrese codigo del item (0 para cortar): ");
        int codigo = scanner.nextInt();
        String nombre;
        int cantidad;
        double precioUnitario;

        while (codigo != 0){
            System.out.println("Ingrese nombre: ");
            nombre = scanner.next();
            System.out.println("Ingrese cantidad: ");
            cantidad = scanner.nextInt();
            System.out.println("Ingrese precio unitario: ");
            precioUnitario = scanner.nextDouble();
            listaItems.add(new Item(codigo, nombre, cantidad, precioUnitario));
            System.out.println("Ingrese codigo del item (0 para cortar): ");
            codigo = scanner.nextInt();
        }
        return listaItems;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
