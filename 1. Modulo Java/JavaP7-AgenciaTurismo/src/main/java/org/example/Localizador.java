package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Localizador {

    private Cliente cliente;
    private List<Producto> paquete;
    private double subtotal;
    private double precioFinal;


    public Localizador(Cliente cliente, List<Producto> paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.paquete = new ArrayList<Producto>();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void agregarProducto(Producto producto) {
        this.paquete.add(producto);
    }

    public void addPaqueteCompleto() {
        Catalogo catalogo = new Catalogo();

        for (int i = 0; i <catalogo.listCatalogo().size() ; i++) {
            this.agregarProducto(catalogo.listCatalogo().get(i));
        }
    }

    public void cerrarOrden(ArrayList<Localizador> localizadores) {
        this.subtotal = this.paquete.stream().mapToDouble(Producto::getPrecio).sum();
        this.precioFinal = this.subtotal;
        double descuento = 0;

        if (tienePaqueteCompleto()) {
            descuento += this.subtotal * 0.1;
        }

        if (this.tienePromoBoletos()) {
            descuento += this.precioFinal * 0.05;
        }

        if (this.tiene2Localizadores(localizadores)) {
            descuento += this.precioFinal * 0.05;
        }

        this.precioFinal = this.subtotal - descuento;
    }

    private boolean tienePaqueteCompleto() {

        List<Boolean> reservas = new ArrayList<>();
        Catalogo catalogo = new Catalogo();

        for (Producto prod : catalogo.listCatalogo()) {
            reservas.add(this.paquete.stream().anyMatch(p -> p.getNombre() == prod.getNombre()));
        }

        return reservas.stream().allMatch(r -> r);
    }

    private Boolean tienePromoBoletos(){
        Catalogo catalogo = new Catalogo();
        long countReservaHotel = this.paquete.stream().filter(p -> p.getNombre() == catalogo.hotel.getNombre()).count();
        long countBoleto = this.paquete.stream().filter(p -> p.getNombre() == catalogo.boletoViaje.getNombre()).count();

        return countReservaHotel >= 2 || countBoleto >= 2;
    }

    private Boolean tiene2Localizadores(ArrayList<Localizador> localizadores){
        return localizadores.stream().count() >= 2;
    }

    @Override
    public String toString() {
        if(this.paquete.size() > 0){
            return "Localizador{" +
                    "\n\tcliente=" + cliente +
                    "\n\tpaquete=" + paquete.toString() +
                    "\n\tSubtotal=" + this.subtotal +
                    "\n\tTotal=" + this.precioFinal +
                    "\n}\n";
        }
        return "Localizador{" +
                "\n\tcliente=" + cliente +
                "\n\tpaquete=" + paquete.toString() +
                "\n}\n";
    }
}
