package org.example.clases;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    List<Reserva> reservaList;
    private double total = 0;
    private double descuento = 1;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Localizador(Cliente cliente, List<Reserva> reservaList) {
        this.cliente = cliente;
        this.reservaList = reservaList;
        calcularElTotal();
    }


    //hacemos todo lo de calcular

    public void calcularElTotal(){
        calcularElTotalNeto();
        validarDescuentos();

        this.total*=this.descuento;
    }

    private void calcularElTotalNeto(){

        this.total = reservaList.stream()
                .mapToDouble(p -> p.getPrecio())
                .sum();
    }

    private void validarDescuentos(){
        //si el cliente tiene el descuento, se aplica
        if(cliente.isTieneEl5DeDescuentoPorTenerMasDe2Localizadores())
            descuento-=0.05;

        //si tiene 2 reservas de hotel y 2 de viaje, se aplica
        if(reservaList.stream().filter(reserva -> reserva.getTipo().equals("Hotel")).count() >= 2
            && reservaList.stream().filter(reserva -> reserva.getTipo().equals("Boleto")).count() >= 2)
            descuento-=0.05;

        //si reservo el paquete completo, se aplica
        if(reservaList.stream().filter(reserva -> reserva.getTipo().equals("Hotel")).count() >= 1
                && reservaList.stream().filter(reserva -> reserva.getTipo().equals("Boleto")).count() >= 1
                && reservaList.stream().filter(reserva -> reserva.getTipo().equals("Comida")).count() >= 1
                && reservaList.stream().filter(reserva -> reserva.getTipo().equals("Transporte")).count() >= 1)
            descuento-=0.05;

    }

    //hacemos el metodo tostring

    @Override
    public String toString() {
        return "\nLocalizador{" +
                "\ncliente=" + cliente +
                ", \nreservaList=" + reservaList +
                ", total=" + total +
                ", descuento=" + descuento +
                '}';
    }
}
