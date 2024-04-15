package org.example.repositorio.impl;

import org.example.entidad.Cliente;
import org.example.entidad.Factura;
import org.example.repositorio.IRepositorioCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IRepositorioCRUDImplFactura implements IRepositorioCRUD<Factura> {
    List<Factura> facturas = new ArrayList<>();
    @Override
    public void guardar(Factura element) {
        facturas.add(element);
    }

    @Override
    public Optional<Factura> encontrar(Long id) {
        Optional<Factura> factura = facturas.stream()
                .filter(e -> e.getCodigo().equals(id))
                .findFirst();

        return factura;
    }

    @Override
    public List<Factura> encontrarTodos() {
        return facturas;
    }

    @Override
    public void borrar(Long id) {
        Optional<Factura> factura = encontrar(id);
        if(factura.isPresent()){
            facturas.remove(factura.get());
            System.out.println("FACTURA BORRADO");
        }
        else{
            System.out.println("FACTURA NO ENCONTRADO");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("----------FACTURAS----------");
        facturas.forEach(System.out::println);
    }
}
