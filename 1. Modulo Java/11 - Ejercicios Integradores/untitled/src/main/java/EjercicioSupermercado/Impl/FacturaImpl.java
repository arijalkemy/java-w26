package EjercicioSupermercado.Impl;

import EjercicioSupermercado.Factura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacturaImpl implements Crud<Factura>{
    private List<Factura> facturas;
    ClienteImpl sistemaClientes;

    public FacturaImpl( ClienteImpl sistemaClientes ) {
        this.facturas = new ArrayList<>();
        this.sistemaClientes = sistemaClientes;
    }


    @Override
    public void altas(Factura... elemento) {
        Arrays.stream(elemento).forEach( x -> {
            if(!sistemaClientes.consulta(x.getCliente())){
                sistemaClientes.altas(x.getCliente());
            }
            facturas.add(x);
        });
    }

    @Override
    public List<Factura> consulta() {
        facturas.forEach(System.out::println);
        return facturas;
    }

    @Override
    public void bajas(Factura elemento) {
        facturas.remove(elemento);
    }

    @Override
    public void modificacion(Factura elemento) {

    }
}
