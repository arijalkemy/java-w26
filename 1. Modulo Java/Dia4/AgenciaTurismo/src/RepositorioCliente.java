import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Cliente buscarCliente(String id) {
        return clientes.getOrDefault(id, null);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}

