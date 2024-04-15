package Punto1;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private String id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;

    public Localizador(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0;
        this.descuento = 0;
    }
    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
        total += reserva.getCosto();
    }
    public void agregarDescuento(double descuento){
        this.descuento += descuento;
    }
    public List<Reserva> getReservas(){
        return reservas;
    }
    public double getTotalConDescuento(){
        return total-(total*descuento/100);
    }
    public void imprimirDetalle(){
        System.out.println("Localizador ID: " + id);
        System.out.println("Cliente: " + cliente);
        System.out.println("Reservas: ");
        reservas.forEach(reserva -> System.out.println(" - " + reserva.getDescripcion()+": $"+reserva.getCosto()));
        System.out.println("Total sin de descuento: " + total);
        System.out.println("Descuento: $ " + (total*descuento/100));
        System.out.println("Total con descuento: $" + (total-(total*descuento/100)));
    }
}
