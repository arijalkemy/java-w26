package org.example.entidades;

public class Localizador {
    private Paquete paquete;
    private Cliente cliente;
    private double totalBrutoAPagar;
    private double totalNetoAPagar;
    private Integer id;
    private static Integer nextId = 1;

    public Localizador(Paquete paquete, Cliente cliente) {
        this.paquete = paquete;
        this.cliente = cliente;
        this.id = nextId;
        nextId++;
        this.totalBrutoAPagar = paquete.calcularTotalDelPaquete();
    }



    public double getTotalNetoAPagar() {
        return totalNetoAPagar;
    }

    public void setTotalNetoAPagar(double totalNetoAPagar) {
        this.totalNetoAPagar = totalNetoAPagar;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Integer getId() {
        return id;
    }

    public double getTotalBrutoAPagar() {
        return totalBrutoAPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }



    @Override
    public String toString() {
        return "Localizador{" +
                "paquete=" + paquete +
                ", cliente=" + cliente +
                '}';
    }
}
