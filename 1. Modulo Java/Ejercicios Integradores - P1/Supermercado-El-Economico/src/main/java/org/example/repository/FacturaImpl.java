package org.example.repository;

import org.example.Cliente;
import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImpl implements ICRUDRepository<Factura> {

    List<Factura> listaDeFacturas = new ArrayList<>();

    @Override
    public void guardar(Factura objeto) {
        listaDeFacturas.add(objeto);
        System.out.println("el total de la factura " +objeto.getCodigo() + " es: " + objeto.getTotalCompra());
    }

    @Override
    public void mostrarPantalla() {
        for (Factura factura : listaDeFacturas) {
            System.out.println(factura);
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {
        Optional<Factura> facturaEncontrada = listaDeFacturas.stream().
                filter((factura) -> codigoBuscado == factura.getCodigo())
                .findFirst();
        facturaEncontrada.ifPresent(System.out::println);
        return facturaEncontrada;
    }

    @Override
    public void eliminar(Long codigoBuscado) {
        Optional<Factura> factura = buscar(codigoBuscado);
        if (factura.isEmpty()) {
            System.out.println("Esa factura no existe en nuestra base de datos");
        } else {
            listaDeFacturas.remove(factura.get());
            System.out.println("Factura borrada exitosamente");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaDeFacturas;
    }
}
