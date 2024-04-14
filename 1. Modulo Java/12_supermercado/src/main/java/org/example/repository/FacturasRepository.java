package org.example.repository;

import org.example.classes.Factura;
import org.example.interfaces.ICRUD;

import java.util.ArrayList;
import java.util.List;

public class FacturasRepository implements ICRUD<Factura> {

    private final List<Factura> facturas;

    public FacturasRepository() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public void create(Factura factura) {
        if(factura != null) {
            this.facturas.add(factura);
            return;
        }
        System.out.println("La factura no puede ser null");
    }

    @Override
    public Factura search(Number id) {
        return this.facturas.stream()
                .filter(factura -> factura.getNumeroFactura() == id.intValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Factura factura) {}

    @Override
    public void delete(Number id) {
        this.facturas.removeIf(factura -> factura.getNumeroFactura() == id.intValue());
    }

    @Override
    public List<Factura> getAll() {
        return List.of();
    }
}
