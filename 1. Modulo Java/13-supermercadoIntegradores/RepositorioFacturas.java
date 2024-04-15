import java.util.ArrayList;
import java.util.List;

public class RepositorioFacturas {
    /**
     * cumple la funcion de almacenar y se hace cargo de las responsabilidades inherentes a un repositorio de facturas.
     */
    private RepositorioClientes repoCliente;
    private static List<Factura> repoFactura = new ArrayList<>();

    public RepositorioFacturas(RepositorioClientes repoCliente) {
        this.repoCliente = repoCliente;
    }

    public void agregarFactura(Factura factura){
        /**
         * chequea si el cliente de la factura figura en el repositorio.
         * en caso que si, se agrega la factura al repositorio.
         * de no estarlo, se se agrega al cliente a RepositorioClientes automaticamente
         */
        if (chequearCliente(factura.getCliente())){
            repoFactura.add(factura);
            System.out.println("Factura agregada correctamente.");
            System.out.println("El monto total de la misma es " + factura.getTotalCompra());
        }else{
            System.out.println("El cliente no esta registrado, se agrega al mismo al repositorio de clientes.");
            repoCliente.agregarCliente(factura.getCliente());
            repoFactura.add(factura);
            System.out.println("Factura agregada correctamente.");
            System.out.println("El monto total de la misma es " + factura.getTotalCompra());
        }
    }

    private boolean chequearCliente(Cliente cliente){
        int clave = cliente.getDni();
        return repoCliente.chequeoCliente(clave);
    }
}
