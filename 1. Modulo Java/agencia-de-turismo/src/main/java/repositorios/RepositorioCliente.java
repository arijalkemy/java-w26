package repositorios;

import Interfaces.ILocalizador;
import model.Cliente;
import model.Localizador;
import servicios.ManejadorDeDescuentos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    List<Cliente> clientes = new ArrayList<>();

    private static RepositorioCliente repositorioCliente;

    public static RepositorioCliente obtenerInstancia(){
        if(repositorioCliente!=null){
            return repositorioCliente;
        } else {
            repositorioCliente = new RepositorioCliente();
            return repositorioCliente;
        }
    }
    private RepositorioCliente(){

    }

    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> obtenerTodosLosClientes(){
        return  clientes;
    }
    public void guardarLocalizador(Cliente cliente, Localizador localizador) {

        if(!clientes.contains(cliente)){
            clientes.add(cliente);
        }

        localizador.setCliente(cliente);
        ILocalizador localizadorAGuardar = ManejadorDeDescuentos.aplicarDescuentos(cliente,localizador);
        cliente.guardarNuevoLocalizador(localizadorAGuardar);

        System.out.println(localizadorAGuardar.toString());
    }

}
