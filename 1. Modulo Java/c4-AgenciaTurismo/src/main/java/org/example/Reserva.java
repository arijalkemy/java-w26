package org.example;

public class Reserva {
    private double descuento;
    private Cliente cliente;
    private Paquete paquete;
    private double valorTotal;
    private double valorFinal;

    public Reserva() {
    }

    public Reserva( Cliente cliente, Paquete paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.valorTotal = this.paquete.costoTotal();
        this.realizarDescuento();
        this.valorFinal = Math.round(valorTotal - (valorTotal * this.descuento));

    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void realizarDescuento(){
        float totalDescuento = 0;
        if(cliente.getCantidad() >= 2){
            totalDescuento += 5;
        }

        totalDescuento += this.paquete.calcularDescuentoPaquete();

         this.descuento = totalDescuento / 100;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "descuento=" + descuento +
                ", cliente=" + cliente +
                ", paquete=" + paquete +
                ", valorTotal=" + valorTotal +
                ", valorFinal=" + valorFinal +
                '}';
    }
}
