package org.example.model;

import java.util.List;

public class Factura {
   private Long codigo;
   private Cliente cliente;
   private List<Iteam> listaIteam;
   private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Iteam> listaIteam, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaIteam = listaIteam;
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

    public List<Iteam> getListaIteam() {
        return listaIteam;
    }

    public void setListaIteam(List<Iteam> listaIteam) {
        this.listaIteam = listaIteam;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaIteam=" + listaIteam +
                ", total=" + total +
                '}';
    }
}
