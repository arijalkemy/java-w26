package Supermercado.CRUD;

import Supermercado.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUD<Factura> {

    List<Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void guardar(Factura factura) {
        listaFacturas.add(factura);
    }

    @Override
    public void mostrar() {
        for(Factura factura : listaFacturas){
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        for (Factura fact : listaFacturas){
            if(fact.getCliente().getDni().equals(id)){
                System.out.println("Factura encontrado: ");
                System.out.println(fact.toString());
                return Optional.of(fact);
            }else {
                System.out.println("Factura no encontrada");
            }
        }return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Factura> fact = this.buscar(id);
        if(fact.isEmpty()){
            System.out.println("Factura no encontrado para borrar");
        }else {
            System.out.println("Cliente eliminado exitosamente");
            listaFacturas.remove(fact.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
