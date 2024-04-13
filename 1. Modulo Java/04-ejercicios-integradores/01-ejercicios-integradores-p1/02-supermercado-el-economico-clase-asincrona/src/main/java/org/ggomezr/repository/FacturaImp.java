package org.ggomezr.repository;

import org.ggomezr.Cliente;
import org.ggomezr.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura>{

    List<Factura> facturas = new ArrayList<>();
    @Override
    public void save(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public void mostrarPorPantalla() {
        for (Factura factura: facturas){
            System.out.println("-----------------------------");
            System.out.println("Codigo: " + factura.getCodigo());
            System.out.println("Cliente: " + factura.getCliente());
            System.out.println("Items: " + factura.getItems());
            System.out.println("Total compra: " + factura.getTotalCompra());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void buscar(Long codigoFactura) {
        Optional<Factura> facturaEncontrada = facturas.stream().filter(factura -> Objects.equals(factura.getCodigo(), codigoFactura)).findFirst();

        if(facturaEncontrada.isPresent()) {
            mostrarObjeto(facturaEncontrada);
        }else{
            System.out.println("Factura no encontrada");
        }
    }

    @Override
    public void eliminar(Long codigoFactura) {
        boolean removed = facturas.removeIf(factura -> Objects.equals(factura.getCodigo(), codigoFactura));
        if(removed){
            System.out.println("Factura eliminada correctamente");
        }else{
            System.out.println("Factura no encontrada");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }

    @Override
    public void mostrarObjeto(Optional<Factura> factura) {
        System.out.println("-----------------------------");
        System.out.println("Codigo: " + factura.get().getCodigo());
        System.out.println("Cliente: " + factura.get().getCliente());
        System.out.println("Items: " + factura.get().getItems());
        System.out.println("Total compra: " + factura.get().getTotalCompra());
        System.out.println("-----------------------------");
    }
}
