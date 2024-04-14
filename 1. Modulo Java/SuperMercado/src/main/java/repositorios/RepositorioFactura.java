package repositorios;

import modelo.Cliente;
import modelo.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioFactura implements Repositorio<Factura>{

    List<Factura> facturas = new ArrayList<>();

    @Override
    public Optional<Factura> buscarPorId(String id) {
        Optional<Factura> factura = facturas.stream().filter(f -> f.getId() == Integer.parseInt(id)).findAny();

        return factura;
    }

    @Override
    public void guardar(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public void eliminar(Factura factura) {
        facturas.remove(factura);
    }

    @Override
    public List<Factura> obtenerTodos() {
        return facturas;
    }
}
