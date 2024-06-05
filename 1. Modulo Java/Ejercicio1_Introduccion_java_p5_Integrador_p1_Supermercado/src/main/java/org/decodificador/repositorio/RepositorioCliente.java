package org.decodificador.repositorio;

import org.decodificador.modelo.Cliente;
import org.decodificador.modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioCliente {
    private List<Cliente> lista_Cliente;

    public RepositorioCliente(){
        lista_Cliente = new ArrayList<Cliente>();
        this.crearListaClientes();
    }
    //Creacion del listado de clientes
    private void crearListaClientes(){
        lista_Cliente.add(new Cliente(1, "Cristian", "Torres"));
        lista_Cliente.add(new Cliente(2, "Daniel", "Rodriguez"));
        lista_Cliente.add(new Cliente(3, "Josep", "Gonzo"));
    }

    //Consultar todos los Clientes del sistema
    public List<Cliente> consultarClientes(){
        return lista_Cliente;
    }

    //Consultar Cliente del sistema por filtro
    public Cliente filtrarCliente(Integer dni){
        List<Cliente> cliente = lista_Cliente.stream().filter(c -> c.getDni().equals(dni)).collect(Collectors.toList());
        return cliente.get(0);
    }

    //Eliminar cliente de la lista
    public void eliminarCliente(Integer dni){
        lista_Cliente.removeIf(c -> c.getDni().equals(dni));
    }

}
