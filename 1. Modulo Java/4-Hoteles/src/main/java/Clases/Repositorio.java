package Clases;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
}
