package meli.bootcamp.entidades;

import meli.bootcamp.implementaciones.ClienteImp;
import meli.bootcamp.implementaciones.FacturaImp;

public class Supermercado {
    ClienteImp clienteImp;
    FacturaImp facturaImp;

    public Supermercado() {

        this.clienteImp = new ClienteImp();
        this.facturaImp = new FacturaImp(clienteImp);
    }

    public void agregarClientes( Cliente ... clientes){
        clienteImp.save(clientes);
    }

    public void mostrarClientes(){
        clienteImp.findAll();
    }

    public void eliminarCliente( Cliente cliente){
        clienteImp.delete(cliente);
    }

    public void buscarClientePorId(Long id){
        Cliente cliente = clienteImp.findById(id);
        if(cliente != null) {
            System.out.println("Se encontro el  " + cliente);
        } else {
            System.out.println("No se encontro el cliente con dni " + id);
        }
    }

    public void agregarFacturas( Factura ... facturas) {
        facturaImp.save(facturas);
    }

    public void mostrarFacturas(){
        facturaImp.findAll();
    }

}