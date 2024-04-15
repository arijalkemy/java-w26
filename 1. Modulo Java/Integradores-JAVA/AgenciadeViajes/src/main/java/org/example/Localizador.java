package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservaList;
    private double total;
    private Double descuento=1.0;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservaList = new ArrayList<>();
        this.total = 0;
    }

    public Localizador(Cliente cliente, List<Reserva> reserva, double total) {
        this.cliente = cliente;
        this.reservaList = reserva;
        this.total = total;
    }

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

    public void agregarReserva(Reserva reserva){
        this.reservaList.add(reserva);
    }

    public void calcularTotal(){
        int contadorHotel = 0;
        int contadorComida = 0;
        int contadorBoletoViaje = 0;
        int contadorTransporte = 0;
        for(Reserva r:reservaList){
            if(r.tipo.equals("Hotel")){
                contadorHotel++;
            }else if(r.tipo.equals("Comida")){
                contadorComida++;
            }else if(r.tipo.equals("BoletoViaje")){
                contadorBoletoViaje++;
            }else if(r.tipo.equals("Transporte")){
                contadorTransporte++;
            }
            this.total += r.costo;
        }
        if(contadorHotel>0&&contadorComida>0&&contadorTransporte>0&&contadorBoletoViaje>0){
            this.descuento -= 0.1;
        }
        if(contadorHotel>2&&contadorBoletoViaje>2){
            this.descuento -= 0.05;
        }
    }
    public void aplicarDescuento(){
        this.total *= this.descuento;
    }

    public void modificarDescuento(double nuevoDescuento){
        this.descuento -= nuevoDescuento;
    }

    @Override
    public String toString() {
        double valor = (1 - descuento)*100;
        System.out.println(valor);
        int descuentoReal = (int)(Math.round(valor));
        return "Localizador{" +
                "cliente=" + cliente .toString()+
                ", reservaList=" + reservaList +
                ", total=" + total +
                ", descuento=" + descuentoReal + "%" +
                '}';
    }
}
