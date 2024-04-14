package org.example.bonus;

import org.example.Cliente;
import org.example.Factura;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFactura implements ICrud<Factura> {

    List<Factura> listaFacturas;

    public RepositorioFactura() {
        this.listaFacturas = new ArrayList<>();
    }

    @Override
    public void alta(Factura factura) {
        if (listaFacturas.stream().filter(f -> f.getId().equalsIgnoreCase(factura.getId())).count() > 0) {
            System.out.println("Ya existe una factura con el id: " + factura.getId());
        } else {
            factura.calcularTotal();
            listaFacturas.add(factura);
            System.out.println("Se agrego la factura: " + factura);
        }
    }

    @Override
    public void baja(String id) {
        boolean eliminarOK = listaFacturas.removeIf(i -> i.getId().equals(id));
        if (eliminarOK) {
            System.out.println("El cliente con el DNI: " + id + " fue eliminado de la lista");
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }
    }

    @Override
    public Factura buscar(String id) {
        return listaFacturas.stream()
                .filter(f -> f.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public void mostrarLista() {
        listaFacturas.forEach(System.out::println);
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
