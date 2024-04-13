import java.util.HashMap;
import java.util.Map;

public class RepositorioClientes {
    private Map<String, Cliente> clientes;

    public RepositorioClientes() {
        clientes = new HashMap<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getNombre(), cliente);
    }

    public Cliente obtenerCliente(String nombre) {
        return clientes.get(nombre);
    }
}

