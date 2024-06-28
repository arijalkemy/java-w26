import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {

    private static List<Cliente> listaClientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public static Cliente buscarCliente(String id){
        return listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
