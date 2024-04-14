package org.example.classes;

import org.example.interfaces.ISupermercado;
import org.example.repository.ClientesRepository;
import org.example.repository.FacturasRepository;

public class Supermercado implements ISupermercado {

    private FacturasRepository facturasRepository;
    private ClientesRepository clientesRepository;

    public Supermercado() {
        this.facturasRepository = new FacturasRepository();
        this.clientesRepository = new ClientesRepository();
    }

    // CRUD CLIENTE

    @Override
    public void crearCliente(Cliente cliente) {
        this.clientesRepository.create(cliente);
    }

    @Override
    public Cliente buscarCliente(long dni) {
        return this.clientesRepository.search(dni);
    }

    @Override
    public void eliminarCliente(long dni) {
       this.clientesRepository.delete(dni);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        this.clientesRepository.update(cliente);
    }

    // ------------

    // CRUD FACTURAS

    @Override
    public void crearFactura(Factura factura) {
        if(this.clientesRepository.search(factura.getCliente().getDni()) == null) {
            System.out.print("El cliente NO existe en el sistema, se procede a crearlo... creado. ");
            this.clientesRepository.create(factura.getCliente());
        }
        this.facturasRepository.create(factura);
        System.out.println("Factura creada con éxito");
    }

    @Override
    public void eliminarFactura(int id) {
        this.facturasRepository.delete(id);
    }

    @Override
    public void modificarFactura(int id) {}

    @Override
    public Factura buscarFactura(int id) {
        return this.facturasRepository.search(id);
    }
}
