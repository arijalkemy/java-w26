package org.example.repository;

import org.example.model.Cliente;
import org.example.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {
    List<Factura> facturasList = new ArrayList<>();
    @Override
    public void save(Factura objeto) {
        facturasList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura factura : facturasList) {
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        for (Factura factura : facturasList) {
            System.out.println("factura encontrada: " + factura.toString());
            return Optional.of(factura);
        }
        System.out.println("factura no encontrada");
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Factura> factura = buscar(id);
        if (factura.isEmpty()) {
            System.out.println("cliente no encontrado");
        }else {
            System.out.println("cliente removido");
            facturasList.remove(factura.get());
        }
    }

    @Override
    public List<Factura> buscarTodos() {
        return facturasList;
    }
}
