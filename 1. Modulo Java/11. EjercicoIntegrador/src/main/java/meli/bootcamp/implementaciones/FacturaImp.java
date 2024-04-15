package meli.bootcamp.implementaciones;

import meli.bootcamp.entidades.Factura;
import meli.bootcamp.interfaces.ICrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacturaImp implements ICrud<Factura>{
    private List<Factura> facturas;
    ClienteImp clientes;

    public FacturaImp( ClienteImp clientes ) {
        this.facturas = new ArrayList<>();
        this.clientes = clientes;
    }


    @Override
    public void save(Factura... factura) {
        Arrays.stream(factura).forEach( x -> {
            if(!clientes.search(x.getCliente())){
                clientes.save(x.getCliente());
            }
            facturas.add(x);
        });
    }

    @Override
    public List<Factura> findAll() {
        facturas.forEach(System.out::println);
        return facturas;
    }

    @Override
    public void delete(Factura factura) {
        facturas.remove(factura);
    }

    @Override
    public void update(Factura factura) {

    }

    @Override
    public Factura findById(Long id) {
        return null;
    }
}