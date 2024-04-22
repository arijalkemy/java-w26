package meli.bootcamp;


import java.util.List;

public class Main {
  public static void main(String[] args) {
    mostrarDatosDeClientes(obtenerClientes());
  }

  public static List<Cliente> obtenerClientes() {
    return List.of(
        new Cliente("12345678", "Juan", "Perez"),
        new Cliente("87654321", "Maria", "Gomez"),
        new Cliente("45678912", "Carlos", "Lopez"),
        new Cliente("98765432", "Ana", "Martinez"),
        new Cliente("65432198", "Pedro", "Gonzalez"),
        new Cliente("32198765", "Laura", "Rodriguez")
    );
  }

  public static void mostrarDatosDeClientes(List<Cliente> clientes) {
    for (Cliente cliente : clientes) {
      System.out.println(cliente.nombre() + " " + cliente.apellido() + " - " + cliente.dni());
    }
  }
}