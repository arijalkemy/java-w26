package org.example.supermercado.models;

import org.example.series.Prototipo;

import java.util.List;
public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Producto> productos;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Producto> productos, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String resultado= "Factura: " +"\n"+
                "   Codigo" + codigo +"\n"+
                "   Cliente:" + cliente.toString() +"\n"+
                "   Productos: [";

        for (Producto producto: this.productos){
            resultado+=producto.toString()+"\n";
        }
        resultado+= "   Total: "+this.total;
        return resultado;
    }
}
