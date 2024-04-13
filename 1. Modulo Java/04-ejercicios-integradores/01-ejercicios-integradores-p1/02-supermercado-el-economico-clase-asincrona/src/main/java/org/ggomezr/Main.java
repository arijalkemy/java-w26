package org.ggomezr;

import org.ggomezr.repository.ClienteImp;
import org.ggomezr.repository.FacturaImp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();

//      Crear clientes
        Cliente cliente1 = new Cliente(1111L, "Geraldine", "Gomez");
        Cliente cliente2 = new Cliente(2222L, "Sandra", "Romero");
        Cliente cliente3 = new Cliente(3333L, "Sebastian", "Parra");

//      Agregar los clientes a la lista de clientes
        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.save(cliente3);

//      Imprimir la lista de clientes
        System.out.println("\n----- Lista de clientes -----\n");

         clienteImp.mostrarPorPantalla();

//      Eliminar un cliente por el dni usando Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n- Eliminar cliente\nIngrese el dni del cliente para eliminarlo: ");

        Long dniClienteAEliminar = scanner.nextLong();

        clienteImp.eliminar(dniClienteAEliminar);

//      Imprimir la lista de clientes despues de la eliminacion
        System.out.println("\n----- Lista de clientes -----\n");

        clienteImp.mostrarPorPantalla();

//      Buscar un cliente por el dni usando Scanner
        System.out.print("\n- Buscar cliente\nIngrese el dni del cliente para buscarlo: ");

        Long dniCliente = scanner.nextLong();

        clienteImp.buscar(dniCliente);

//      Crear el array con items para la compra
        List<Item> items = Arrays.asList(
                new Item(12321L, "Bolsa de leche", 1, 3000),
                new Item(22481L, "Jabon en polvo", 2, 4000)
        );

//      Crear una nueva factura
        Factura factura1 = new Factura(cliente1, items);

//      Guardar nueva factura
        facturaImp.save(factura1);

//      Verificar si el cliente esta en la lista de clientes
        if(clienteImp.traerTodos().contains(factura1.getCliente())){
            clienteImp.save(cliente1);
        }

        System.out.print("\nListado completo de facturas: \n");

        facturaImp.mostrarPorPantalla();
    }
}