package EjercicioSupermercado;

import EjercicioSupermercado.Impl.ClienteImpl;
import EjercicioSupermercado.Impl.FacturaImpl;

public class Supermercado {
    ClienteImpl sistemaClientes;
    FacturaImpl sistemaFacturas;

    public Supermercado() {

        this.sistemaClientes = new ClienteImpl();
        this.sistemaFacturas = new FacturaImpl(sistemaClientes);
    }

    public void agregarClientes( Cliente ... clientes){
        sistemaClientes.altas(clientes);
    }

    public void mostrarClientes(){
        sistemaClientes.consulta();
    }

    public void eliminarCliente( Cliente cliente){
        sistemaClientes.bajas(cliente);
    }

    public void eliminarCliente( String dni){
        sistemaClientes.bajas(dni);
    }

    public void agregarFacturas( Factura ... facturas) {
        sistemaFacturas.altas(facturas);
    }

    public void mostrarFacturas(){
        sistemaFacturas.consulta();
    }

    public void eliminarFactura( Factura factura){
        sistemaFacturas.bajas(factura);
    }
}
