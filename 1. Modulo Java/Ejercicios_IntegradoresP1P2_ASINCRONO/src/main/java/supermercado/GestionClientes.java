package supermercado;

import java.util.List;
import java.util.ArrayList;
public class GestionClientes implements CRUD<Cliente>{
    private List<Cliente> clientes = new ArrayList<>();
    @Override
    public void agregar(Cliente cliente){
        clientes.add(cliente);
    }
    @Override
    public void eliminar(Cliente cliente){
        clientes.remove(cliente);
    }
    @Override
    public void actualizar(Cliente antiguoCliente, Cliente nuevoCliente){
        int index = clientes.indexOf(antiguoCliente);
        if(index != -1){
            clientes.set(index, nuevoCliente);
        }
    }
    @Override
    public Cliente buscar(Cliente cliente){
        for(Cliente c: clientes){
            if(c.equals(cliente)){
                return c;
            }
        }
        return null;
    }
    @Override
    public List<Cliente> listar(){
        return clientes;
    }
}
