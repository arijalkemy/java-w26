package org.example.repository;

import org.example.models.Factura;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FacturaImp implements ICRUDRepository<Factura> {
    private Set<Factura> facturas = new HashSet<>();

    @Override
    public void imprimirLista() {
        System.out.println("Lista de facturas: ");
        facturas.forEach(System.out::println);
    }

    @Override
    public boolean save(Factura f) {
        return facturas.add(f);
    }

    @Override
    public boolean delete(Factura f) {
        return facturas.remove(f);
    }

    @Override
    public Optional<Factura> findById(Long codigo) {
        return facturas.stream()
                .filter(f -> f.getCodigo().equals(codigo))
                .findFirst();
    }

    @Override
    public Set<Factura> findAll() {
        return facturas;
    }
}
