package EjerciciosIntegradores.Supermercado;

import java.util.ArrayList;
import java.util.List;

public class ElEconomico extends Supermercado {
    public ElEconomico() {
        this.facturas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            System.out.println("Cliente agregado:");
            System.out.println(cliente);
        }
    }

    public void quitarCliente(int dni){
        Cliente cliente = buscarCliente(dni);
        this.clientes = clientes.stream().filter(c -> c.getDni() != dni).toList();
        System.out.println("Cliente quitado:");
        System.out.println(cliente);
    }

    public void imprimirClientes(){
        for (Cliente cliente : this.clientes) {
            System.out.println(cliente);
        }
    }

    public Cliente buscarCliente(int dni){
        List<Cliente> clienteBusqueda = this.clientes.stream().filter(c -> c.getDni() == dni).toList();
        if(clienteBusqueda.isEmpty()){
            System.out.println("Cliente no encontrado");
            return null;
        }else{
            System.out.println("Cliente encontrado: ");
            System.out.println(clienteBusqueda.get(0));
            return clienteBusqueda.get(0);
        }
    }

    public void agregarFactura(int dni, List<Item> items){
        Cliente cliente = buscarCliente(dni);
        if(cliente != null){
            this.facturas.add(new Factura(cliente, items));
            System.out.println("Factura agregada:");
            System.out.println(this.facturas.get(this.facturas.size()-1));
        }else{
            System.out.println("Cliente no encontrado");
        }
    }
}
