package Punto1;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
public class Repositorio {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public Optional<Cliente> buscarCliente(String id){
        return clientes.stream().filter(c->c.getId().equals(id)).findFirst();
    }
}
