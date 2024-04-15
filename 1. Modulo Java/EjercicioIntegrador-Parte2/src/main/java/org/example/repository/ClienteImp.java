package org.example.repository;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente>{
    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objecto) {
        listaClientes.add(objecto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes){
            System.out.println("DNI:"+c.getDni());
            System.out.println("NOMBRE:"+c.getNombre());
            System.out.println("APELLIDO:"+c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean bandera = false;
        for (Cliente c : listaClientes){
            if (c.getDni().equals(dniBuscado)){
                System.out.println("DNI:"+c.getDni());
                System.out.println("NOMBRE:"+c.getNombre());
                System.out.println("APELLIDO:"+c.getApellido());
                bandera = true;
                return Optional.of(c);
            }
        }
        if (bandera == false){
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<Cliente> cli = this.buscar(dniBorrado);
        if (cli.isEmpty()){
            System.out.println("No se encontro el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
            listaClientes.remove(cli.get());
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}
