package org.example.classes;

import org.example.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements IRepository<Factura> {
    private List<Factura> facturaList;

    public FacturaRepository() {
        this.facturaList = new ArrayList<Factura>();
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public void add(Factura object) {
        try {
            facturaList.add(object);
        } catch(Exception ex) {
            System.out.println("Ocurrió un error al añadir la Factura al listado.");
        }
    }

    @Override
    public Factura get(int id) {
        Optional<Factura> resultado = facturaList
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

        if (resultado.isPresent()) return resultado.get();
        return null;
    }

    @Override
    public List<Factura> getAll() {
        return facturaList;
    }

    @Override
    public void put(int id, Factura object) {
        facturaList.forEach(factura -> {
            if (factura.getId() == id) {
                int indice = facturaList.indexOf(factura);
                facturaList.set(indice, object);
                System.out.println("Factura modificada exitosamente.");
                return;
            };
        });

        System.out.println("No se encontró la factura con el id: " + id);
    }

    @Override
    public void delete(int id) {
        Optional<Factura> resultado = facturaList
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

        if (resultado.isPresent()) {
            facturaList.remove(resultado);
            System.out.println("Factura eliminada exitosamente");
        } else {
            System.out.println("No se encontró la Factura con el id: " + id);
        }
    }
}
