package meli.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // En el servicio que se inicie este caso de uso se debería
    // chequear que el cliente este dentro del repositorio de clientes
    List<Cliente> clientes = obtenerClientes();
    Cliente unCliente = clientes.get(0);

    if (!clientes.contains(unCliente)) {
      clientes.add(unCliente);
    }

    Factura factura = new Factura(unCliente);

    factura.agregarItem(new Item("1234", "Producto 1", 100.0), 2);
    factura.agregarItem(new Item("1235", "Producto 2", 200.0), 1);
    factura.agregarItem(new Item("1236", "Producto 3", 300.0), 3);
    factura.agregarItem(new Item("1237", "Producto 4", 400.0), 4);
    factura.agregarItem(new Item("1238", "Producto 5", 500.0), 5);

    System.out.println("Total: " + factura.obtenerTotal());
  }

  public static List<Cliente> obtenerClientes() {
    List<Cliente> clientes = new ArrayList<>();

    clientes.add(new Cliente("12345678", "Juan", "Perez"));
    clientes.add(new Cliente("87654321", "Maria", "Gomez"));
    clientes.add(new Cliente("45678912", "Carlos", "Lopez"));
    clientes.add(new Cliente("98765432", "Ana", "Martinez"));
    clientes.add(new Cliente("65432198", "Pedro", "Gonzalez"));
    clientes.add(new Cliente("32198765", "Laura", "Rodriguez"));

    return clientes;
  }

  public static void mostrarDatosDeClientes(List<Cliente> clientes) {
    for (Cliente cliente : clientes) {
      System.out.println(cliente.nombre() + " " + cliente.apellido() + " - " + cliente.dni());
    }
  }
}