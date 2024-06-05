package org.decodificador.servicio;

import org.decodificador.modelo.Cliente;
import org.decodificador.repositorio.RepositorioCliente;

import java.util.List;

//Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
public class ServicioCliente {
    private RepositorioCliente repo_clientes;

    //Constructor
    public ServicioCliente() {
        repo_clientes = new RepositorioCliente();
    }

    //Mostrar datos de todos los clientes registrados en el sistema
    public void mostrarDatosdeClientes() {
        List<Cliente> listaClientes = repo_clientes.consultarClientes();
        listaClientes.forEach(System.out::println);
    }
    //Eliminar clientes
    public void eliminarCliente(Integer id) {
        repo_clientes.eliminarCliente(id);
    }

    //Mostrar un cliente en especifico
    public Cliente mostrarCliente(Integer id) {
        Cliente cliente = repo_clientes.filtrarCliente(id);
        if(cliente == null) {
            System.out.println("El cliente no existe");
        }else{
            System.out.println("El cliente es: " + cliente.toString());
        }
        return cliente;
    }

}
