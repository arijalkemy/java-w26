package org.decodificador;

import org.decodificador.servicio.ServicioCliente;
import org.decodificador.servicio.ServicioFactura;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Crear 3 clientes y guardarlos en una collection.
        ServicioCliente servicioCliente = new ServicioCliente();
        //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        System.out.println("___________________________________");
        System.out.println("Mostrar lista de clientes");
        System.out.println("___________________________________");
        servicioCliente.mostrarDatosdeClientes();
        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        System.out.println("___________________________________");
        System.out.println("Eliminar cliente con id:2...");
        servicioCliente.eliminarCliente(2);
        servicioCliente.mostrarDatosdeClientes();
        System.out.println("___________________________________");

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la
        // lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        System.out.println("Buscar cliente con id: 1 ...");
        servicioCliente.mostrarCliente(1);
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        ServicioFactura servicioFactura = new ServicioFactura(servicioCliente);
        servicioFactura.asignarClienteAFactura(1);
    }
}
