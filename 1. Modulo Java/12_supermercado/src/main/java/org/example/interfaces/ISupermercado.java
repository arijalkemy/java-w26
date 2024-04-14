package org.example.interfaces;

import org.example.classes.Cliente;
import org.example.classes.Factura;

public interface ISupermercado {

    void crearCliente(Cliente cliente);
    void eliminarCliente(long dni);
    void modificarCliente(Cliente cliente);
    Cliente buscarCliente(long dni);

    void crearFactura(Factura factura);
    void eliminarFactura(int id);
    void modificarFactura(int id);
    Factura buscarFactura(int id);

}
