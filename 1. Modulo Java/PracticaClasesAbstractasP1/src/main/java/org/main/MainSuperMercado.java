package org.main;

import org.entities.supermercado.Cliente;
import org.entities.supermercado.Factura;
import org.entities.supermercado.Item;
import org.entities.supermercado.interfaces.IRepository;
import org.entities.supermercado.repositorios.ClienteRepository;
import org.entities.supermercado.repositorios.FacturaRepository;

import java.util.*;

public class MainSuperMercado {
    static ClienteRepository repositoryCliente = new ClienteRepository();
    static FacturaRepository repositoryFactura = new FacturaRepository();
    public static void main(String[] args) {
        Cliente clienteUno = new Cliente("1000982603","Pepito","Perez","hola@gmail.com");
        Cliente clienteDos = new Cliente("1000989603","Julito","Ramon","julito@gmail.com");
        Cliente clienteTres =new Cliente("123456789","Juanito","Ramirez","juanito@gmail.com");

        repositoryCliente.guardar(clienteUno);
        repositoryCliente.guardar(clienteDos);
        repositoryCliente.guardar(clienteTres);


        List<Cliente> listaClientes = repositoryCliente.recuperarTodos();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        repositoryCliente.eliminar(clienteUno.getDni());
        System.out.println("\n");

        listaClientes = repositoryCliente.recuperarTodos();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el dni del usuario para buscarlo en el sistema: ");
        String dni = sc.nextLine();

        Cliente cliente = repositoryCliente.recuperar(dni);
        if(cliente != null) {
            System.out.println(cliente.toString());
        }else System.out.println("No se encontro el cliente con dni "+dni);

        //Parte Dos
        Factura factura =new Factura(2000, clienteDos);
        repositoryFactura.guardar(factura);

        //------PRUEBA DE CLIENTE QUE NO EXISTE EN LA COLLECTION
        Cliente clienteNoExistente = new Cliente("231297312","Lionel","Messi","lionel@gmail.com");
        Factura facturaDos =new Factura(2000, clienteDos);
        if(repositoryCliente.recuperar(clienteNoExistente.getDni()) == null) {
            repositoryCliente.guardar(clienteNoExistente);
        }
        repositoryCliente.recuperarTodos().forEach(System.out::println);
        //Creando Items
        Item itemUno = new Item("Leche","Leche deslactosada",3000);
        Item itemDos = new Item("Chocolate","Chocolate normal",2000);
        Item itemTres = new Item("Jugo", "Jugo de Caja",1000);
        //Agregando Items
        facturaDos.agregarItem(itemUno,itemDos,itemTres);
        repositoryFactura.guardar(facturaDos);
        System.out.println(facturaDos.getTotal());
    }

}
