package org.example;

import java.util.List;
import java.util.Optional;

public class Caja {
    public static Factura crearFactura(Cliente cliente, List<Producto> productos, List<Cliente> clientesDB){
        // Verificar si cliente existe
        Optional<Cliente> clienteExiste = clientesDB.stream().filter(cli -> cli.getDni().equals(cliente.getDni())).findFirst();
        if(!clienteExiste.isPresent()) { clientesDB.add(cliente); }

        return new Factura(cliente, productos);
    }

    public static double calcularCosto(Factura factura){
        return factura.getItems().stream().mapToDouble(producto -> producto.getCostoUnitario() * producto.getCantidaComprada()).sum();
    }
}
