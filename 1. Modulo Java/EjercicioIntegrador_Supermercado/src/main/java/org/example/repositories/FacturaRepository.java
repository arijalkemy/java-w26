package org.example.repositories;

import org.example.models.Factura;

import java.util.List;

public class FacturaRepository implements ICRUD<Factura, Integer>{
    @Override
    public Factura create(Factura factura) {
        baseDeDatos.agregarFactura(factura);
        return null;
    }

    @Override
    public List<Factura> read() {
        return null;
    }

    @Override
    public Factura update(Factura factura) {
        return null;
    }

    @Override
    public Factura delete(Factura factura) {
        return null;
    }

    @Override
    public Factura getByID(Integer integer) {
        return null;
    }
}
