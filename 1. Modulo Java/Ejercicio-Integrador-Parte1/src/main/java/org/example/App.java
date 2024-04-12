package org.example;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Instancio clientes
        Cliente clienteUno = new Cliente("111", "NombreUno", "ApellidoUno");
        Cliente clienteDos = new Cliente("222", "NombreDos", "ApellidoDos");
        Cliente clienteTres = new Cliente("333", "NombreTres", "ApellidoTres");

        //Instancio supermercado
        Supermercado supermercado = new Supermercado();

        //Agrego clientes al supermercado
        supermercado.agregarCliente(clienteUno);
        supermercado.agregarCliente(clienteDos);
        supermercado.agregarCliente(clienteTres);

        //Consulto listado de clientes del supermercado y los muestra en pantalla
        supermercado.listadoDeClientes();

        //Elimino al cliente dos de la lista del supermercado
        supermercado.removerCliente(clienteDos);

        System.out.println("\n------ Elimino a un cliente -------");
        //Muesto el listado del supermercado luego de eliminar a un cliente
        supermercado.listadoDeClientes();

        System.out.println("\n------ Busco un cliente por su DNI y lo muestro -------");
        Optional<Cliente> clienteEncontrado = supermercado.buscarClientePorDni("111");

        if(clienteEncontrado.isPresent()){
            System.out.println("Cliente encontrado: "+ clienteEncontrado.toString());
        } else {
            System.out.println("No se encontro un cliente con ese numero de DNI");
        }
    }
}
