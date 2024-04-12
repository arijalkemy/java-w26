package org.example.Clases;

import org.example.Interfaces.ICrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministradorFactura implements ICrud<Factura, Integer> {

    private List<Factura> facturaList;

    public AdministradorFactura() {
        this.facturaList = new ArrayList<>();
    }
    public AdministradorFactura(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaList.stream()
                .filter(f -> f.getId() == id)
                .findFirst();
    }

    @Override
    public List<Factura> findAll() {
        return facturaList;
    }

    @Override
    public Factura save(Factura factura) {
        facturaList.add(factura);
        return factura;
    }

    @Override
    public Factura update(Factura factura) {
        Optional<Factura> facturaOptional = facturaList.stream()
                .filter(f -> f.getId() == factura.getId())
                .findFirst();

        if(facturaOptional.isEmpty())
            return null;

        facturaList.remove(facturaOptional);
        facturaList.add(factura);
        return factura;
    }

    @Override
    public void delete(Factura factura) {
        facturaList.remove(factura);
    }

}
