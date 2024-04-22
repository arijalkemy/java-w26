package org.example;

import org.example.repository.ClienteImpl;
import org.example.repository.FacturaImpl;
import org.example.repository.ItemImpl;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClienteImpl clienteImpl = new ClienteImpl();
        Cliente clienteUno = new Cliente(12393494, "Juan", "Perez");
        Cliente clienteDos = new Cliente(39009482, "Pedro", "Pascal");
        Cliente clienteTres = new Cliente(30625917, "Mia", "Ramos");

        //agrego a la collecion los clientes

        clienteImpl.guardar(clienteUno);
        clienteImpl.guardar(clienteDos);
        clienteImpl.guardar(clienteTres);

        //muestro los clientes por pantall
        clienteImpl.mostrarPantalla();

        // pido por pantalla dni para ver si ese usuario esta en la lista de clientes
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un dni para buscar usuario");
        long dniBuscado = sc.nextLong();
        clienteImpl.buscar(dniBuscado);

        //elimino un cliente y muestro la lista luego del cambio
        System.out.println("ingrese el dni a eliminar");
        Long dniBorrado = sc.nextLong();
        clienteImpl.eliminar(dniBorrado);


        //creo dos productos y los agrego a la lista de items
        Item cocaCola = new Item(1, "Coca-cola", 10, 1600);
        Item pepsi = new Item(2, "pepsi-cola", 4, 1500);

        ItemImpl itemImpl = new ItemImpl();
        itemImpl.guardar(cocaCola);
        itemImpl.guardar(pepsi);

        //creo una factura asociando un cliente con la lista de items
        FacturaImpl facturaImpl = new FacturaImpl();
        Factura facturaUno = new Factura(1, clienteUno, itemImpl.traerTodos());

        //si el cliente no esta en la bd de clientes lo agrego
        Optional<Cliente> clienteOtional = clienteImpl.buscar(clienteUno.getDni());
        if (clienteOtional.isEmpty()){
            clienteImpl.guardar(clienteUno);
        }
        //luego guardo la factura
        facturaImpl.guardar(facturaUno);



    }
}
