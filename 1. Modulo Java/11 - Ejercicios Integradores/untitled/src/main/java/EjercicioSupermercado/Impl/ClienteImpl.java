package EjercicioSupermercado.Impl;

import EjercicioSupermercado.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteImpl  implements Crud<Cliente>{
    private List<Cliente> clientes;

    public ClienteImpl() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void altas(Cliente ... elemento) {
        clientes.addAll( Arrays.stream(elemento).toList());
    }

    @Override
    public List<Cliente> consulta() {
        clientes.forEach( System.out::println );
        return clientes;
    }

    public boolean consulta( Cliente cliente) {
        return clientes.contains(cliente);
    }

    @Override
    public void bajas(Cliente elemento) {
        clientes.remove(elemento);
    }

    @Override
    public void modificacion(Cliente elemento) {
        clientes.removeIf( x -> x.getDni().equals(elemento.getDni()));
        altas( elemento );
    }

    public void bajas( String dni ){
        if( !clientes.removeIf( x -> x.getDni().equals(dni)) ){
            System.out.println("No se pudo eliminar al cliente con dni: " + dni);
        }
    }
}
