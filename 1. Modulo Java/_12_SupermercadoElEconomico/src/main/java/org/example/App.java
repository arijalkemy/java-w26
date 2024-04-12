package org.example;

import org.example.Clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        boolean bandera = true;
        Scanner teclado = new Scanner(System.in);
        AdministradorCliente administradorCliente = new AdministradorCliente();

        do {
            System.out.println("¿Que accion desea realizar?" +
                    "\n 1. Crear y cargar clientes " +
                    "\n 2. Ver el listado de clientes " +
                    "\n 3. Eliminar cliente " +
                    "\n 4. Buscar cliente " +
                    "\n 5. Crear y ver la factura" +
                    "\n 6. Terminar");

            int accion = teclado.nextInt();

            switch (accion){
                case 1:
                    Cliente cliente1 = new Cliente(42333555L, "Marcos", "Bellotti");
                    Cliente cliente2 = new Cliente(40231555L, "Juan", "Zbrun");
                    Cliente cliente3 = new Cliente(42332555L, "Pedro", "Rodriguez");

                    List<Cliente> clientes = new ArrayList<>();
                    clientes.add(cliente1);
                    clientes.add(cliente2);
                    clientes.add(cliente3);

                    administradorCliente = new AdministradorCliente(clientes);

                    break;
                case 2:
                    if(administradorCliente.getClientes().size() == 0)
                        System.out.println("No hay clientes cargados");
                    else{
                        System.out.println("Listado: ");
                        administradorCliente.getClientes().forEach(System.out::println);
                    }
                    break;
                case 3:
                    if(administradorCliente.getClientes().size() == 0)
                        System.out.println("No hay clientes cargados");
                    else{
                        administradorCliente.delete(administradorCliente.getClientes().get(0));
                    }
                    break;
                case 4:
                    System.out.println("Ingrese un dni a buscar: ");
                    Long dni = teclado.nextLong();

                    Optional<Cliente> clienteBuscado = administradorCliente.findById(dni);

                    //Si encuentra al cliente lo muestra, sino no
                    clienteBuscado.ifPresent(cliente-> System.out.println(cliente.toString()));
                    if(clienteBuscado.isEmpty())
                        System.out.println("No se encontro el cliente");
                    break;
                case 5:
                    Cliente clienteAAgregar = new Cliente(332L,"pepe","mujica");

                    Item coca = new Item("AA112", "Coca", 22, 2300);
                    Item pepsi = new Item("AA113", "Pepsi", 122, 1900);
                    Item seven = new Item("AA114", "Seven", 2, 2350);

                    List<Item> itemList = new ArrayList<>();
                    itemList.add(coca);
                    itemList.add(pepsi);
                    itemList.add(seven);

                    Factura factura = new Factura(1, clienteAAgregar, itemList);

                    AdministradorFactura administradorFactura = new AdministradorFactura();

                    if(!administradorCliente.getClientes().contains(clienteAAgregar))
                        administradorCliente.save(clienteAAgregar);

                    administradorFactura.save(factura);

                    administradorFactura.getFacturaList().forEach(System.out::println);
                    break;
                case 6:
                    bandera = false;
                    break;
                default:
                    if(bandera){
                        System.out.println("Desea seguir cargando? (1 es si, 2 es no)");
                        accion = teclado.nextInt();

                        if(accion == 1)
                            bandera = false;
                    }
            }

        }while(bandera);
    }

}
