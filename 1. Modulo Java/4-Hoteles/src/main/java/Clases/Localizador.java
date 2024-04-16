package Clases;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private String nombreCliente;

    private List<Reserva> reservas;

    private List<Descuento> descuentos;

    private double total = 0;

    public Localizador(String nombreCliente, List<Reserva> reservas, List<Descuento> descuentos) {
        this.nombreCliente = nombreCliente;
        this.reservas = reservas;
        this.descuentos = descuentos;
    }

    public double getPrecioTotal(){
        this.total = precioTotalReservas();
        for(Descuento descuento: descuentos){
            System.out.println("Entre a aplicar descuento");
            System.out.println(descuento.getClass());
            this.total = descuento.aplicarDescuento(this);
        }
        return this.total;
    }

    private double precioTotalReservas(){
        return reservas.stream().mapToDouble(x -> x.getPrecio()).sum();
    }

    public double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
