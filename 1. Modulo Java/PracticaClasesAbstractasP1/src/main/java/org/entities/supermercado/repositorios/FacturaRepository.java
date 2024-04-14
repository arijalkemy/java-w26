package org.entities.supermercado.repositorios;

import org.entities.supermercado.Cliente;
import org.entities.supermercado.Factura;
import org.entities.supermercado.interfaces.IRepository;

import java.util.*;

public class FacturaRepository implements IRepository<Factura> {
    Map<UUID, Factura> facturaMap = new HashMap();

    @Override
    public void guardar(Factura factura) {
        if(!factura.getItems().isEmpty()){
            facturaMap.put(factura.getId(), factura);
            System.out.println("Factura : " + factura.getId() +" guardada con exito");
        }
        System.out.println("No se puede guardar la factura si no tiene items");
    }

    @Override
    public Factura recuperar(String id) {
        return facturaMap.get(UUID.fromString(id));
    }

    @Override
    public List<Factura> recuperarTodos() {
        return new ArrayList<>(facturaMap.values());
    }

    @Override
    public void eliminar(String id) {
        facturaMap.remove(UUID.fromString(id));
    }
}
