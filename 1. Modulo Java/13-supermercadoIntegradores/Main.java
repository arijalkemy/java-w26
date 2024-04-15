import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        //se instancia el repositorio de clientes.
        RepositorioClientes repoClientes = new RepositorioClientes();
        RepositorioFacturas repoFacturas = new RepositorioFacturas(repoClientes);

        Cliente cliente1 = new Cliente(40721425, "Andres Garcia");
        Cliente cliente2 = new Cliente(1234556, "Jorge Alfajor");
        Cliente cliente3 = new Cliente(876543, "Alberto Mesa");



        repoClientes.agregarCliente(cliente1, cliente2, cliente3);
        /** TESTEO DE FUNCIONALIDADES DE REPO
        repoClientes.mostarClientes();

        repoClientes.eliminarCliente(876543);

        repoClientes.mostarClientes();

        repoClientes.busquedaManual();
         */

        Factura factura = new Factura();
        factura.crearFactura();
        repoFacturas.agregarFactura(factura);


    }
}
