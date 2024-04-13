package org.example;

import org.example.models.Cliente;
import org.example.models.Factura;
import org.example.models.Item;
import org.example.repository.ClienteImp;
import org.example.repository.FacturaImp;
import org.example.repository.ItemImp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();

        Set<Cliente> clientes = new HashSet<Cliente>(){{
            add(new Cliente(333333333L,"hernan","perez"));
            add(new Cliente(1L,"Lucas","gonzales"));
            add(new Cliente(333333333L,"julia","fernandez"));
        }};

        clientes.forEach(c -> clienteImp.save(c));
        clienteImp.imprimirLista();

        clienteImp.delete(
                clientes.stream().findFirst().orElse(null)
        );

        System.out.println("reimprimir clientes luego eliminacion");
        clienteImp.imprimirLista();

       Cliente cliente = clienteImp.buscarClientePorDNI();
       //imprimir cliente encontrado
        if (Objects.nonNull(cliente)) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No se pudo encontrar al cliente");
        }

        Set<Item> items = new HashSet<Item>(){{
            add(new Item(
                    1L,
                    "papa",
                    2,
                    1000
            ));
            add(new Item(
                    2L,
                    "choclo",
                    5,
                    300
            ));
        }};

        items.forEach(i-> itemImp.save(i));

        Factura factura = new Factura(
                1L,
            items,
                new Cliente(2L, "Ricardo", "Perez")
        );

        facturaImp.save(factura);

        System.out.println("impresion de factura: ");
        facturaImp.imprimirLista();

    }
}
