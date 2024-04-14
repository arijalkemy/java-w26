package org.example.Collections;

import org.example.Model.Cliente;
import org.example.Model.Factura;

import java.util.ArrayList;

public class FacturaCollection  implements Actions {


    ArrayList<Factura> facturas;
    Integer ultimoFolio = 00000;


    public FacturaCollection() {
        this.facturas = new ArrayList<>();
    }

    public void agregaFactura(Factura factura, ClienteCollection collection){
        if (this.checkClient(factura.getCliente(), collection)){
            this.ultimoFolio += 1;
            factura.setFolio(ultimoFolio);
            this.facturas.add(factura);

        }
        else{
            System.out.println("No se pudo agregar la factura");
        }
    }

    @Override
    public void guardar(Object factura) {
        this.facturas.add((Factura) factura);
    }

    @Override
    public void mostrar() {
        for (Factura factura : this.facturas) {
            System.out.println(factura);
        }
    }

    @Override
    public Object buscar(String folio) {
        return this.facturas.stream().filter(f -> f.getFolio().equals(folio)).findFirst().orElse(null);
    }

    @Override
    public void eliminar(String folio) {
        Factura deletedFolio = (Factura) this.buscar(folio);
        boolean removed = this.facturas.removeIf(p -> p.getFolio().equals(folio));

        if (removed) {
            System.out.println("La Factura " + deletedFolio.getFolio() + " A nombre de " + deletedFolio.getCliente().getNombre() + " Fue eliminada");
        }
    }

    private boolean checkClient(Cliente cliente, ClienteCollection collection){
        return collection.buscar(cliente.getDni()) != null;
    }

    @Override
    public String toString() {
        return "FacturaCollection{" +
                "facturas=" + facturas +
                '}';
    }
}
