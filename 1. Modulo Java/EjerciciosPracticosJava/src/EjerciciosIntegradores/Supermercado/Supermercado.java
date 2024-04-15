package EjerciciosIntegradores.Supermercado;

import java.util.List;

public abstract class Supermercado {
    List<Factura> facturas;
    List<Cliente> clientes;

    public abstract void agregarCliente(Cliente cliente);

    public abstract void quitarCliente(int dni);

    public abstract void imprimirClientes();

    public abstract Cliente buscarCliente(int dni);

    public abstract void agregarFactura(int dni, List<Item> items);
}
