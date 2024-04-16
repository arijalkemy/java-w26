package Supermercado.CRUD;

import Supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUD<Cliente> {
List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente cliente){
        listaClientes.add(cliente);
    }

    @Override
    public void mostrar() {
        for( Cliente cliente : listaClientes){
            System.out.println( "Cliente:" +cliente.getNombre() + cliente.getApellido() +
                    "DNI: " + cliente.getDni());
        }
    }

    @Override
    public Optional<Cliente> buscar(String id) {
      for (Cliente cliente : listaClientes){
          if(cliente.getDni().equals(id)){
              System.out.println("Cliente encontrado: " + cliente.getNombre() + cliente.getApellido());
              return Optional.of(cliente);
          }
      }return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
    Optional<Cliente> cliente = this.buscar(id);
    if(cliente.isEmpty()){
        System.out.println("Cliente no encontrado para borrar");
    }else {
        System.out.println("Cliente eliminado exitosamente");
        listaClientes.remove(cliente.get());
    }
    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}
