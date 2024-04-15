import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {

    private static List<Cliente> repoCliente = new ArrayList<>();

    public void agregarCliente(Cliente cliente){
        repoCliente.add(cliente);
    }

}
