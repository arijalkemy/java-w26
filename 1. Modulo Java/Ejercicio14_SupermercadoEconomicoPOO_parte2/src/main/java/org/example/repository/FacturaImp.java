package org.example.repository;

import org.example.model.Cliente;
import org.example.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements repositoryCRUD<Factura>{
    private List<Factura> facturaList = new ArrayList<>();
    @Override
    public void save(Factura objeto) {
        facturaList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura fact : facturaList){
            System.out.println(fact.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(long id) {
        for (Factura fact : facturaList){
            if (fact.getCodigo().equals(id)){
                System.out.println("------ Factura encontrada!!! ------");
                System.out.println("Dni: "+fact.toString());
                return Optional.of(fact);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(long id) {
        Optional<Factura> fact = this.buscar(id);
        if (fact.isEmpty()) {
            System.out.println("Se ha eliminado el cliente exitosamente!!!");
            facturaList.remove(fact.get());
        } else {
            System.out.println("No se encontro el cliente a eliminar");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturaList;
    }
}
