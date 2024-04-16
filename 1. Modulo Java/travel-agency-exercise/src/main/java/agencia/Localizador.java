package agencia;

import agencia.productos.Producto;
import agencia.productos.ProductoTypes;
import agencia.productos.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Producto> paquete;

    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public Localizador(Cliente cliente, List<Producto> paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.paquete = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        this.paquete.add(producto);
    }

    public void cerrarOrden(Repositorio repositorio) {
        Double precioTotal = this.paquete.stream().map(p -> p.getPrecio()).reduce(Double.valueOf(0), Double::sum);
        Double porcentaje = Double.valueOf(1);
        if (tienePaqueteCompleto()) {
            porcentaje = porcentaje * 0.9;
        }
        if (tienePromoReservaBoleto()) {
            porcentaje = porcentaje * 0.95;
        }
        if (repositorio.tiene2OmasLocalizadores(this.cliente.getDni())) {
            porcentaje = porcentaje * 0.95;
        }
        this.precio = precioTotal * porcentaje;
    }

    private boolean tienePaqueteCompleto() {
        boolean tieneReservaHotel = this.paquete.stream().anyMatch(p -> p.getCategoria() == ProductoTypes.RESERVA_HOTEL);
        boolean tieneComida = this.paquete.stream().anyMatch(p -> p.getCategoria() == ProductoTypes.COMIDA);
        boolean tieneBoleto = this.paquete.stream().anyMatch(p -> p.getCategoria() == ProductoTypes.BOLETO);
        boolean tieneTransporte = this.paquete.stream().anyMatch(p -> p.getCategoria() == ProductoTypes.TRANSPORTE);

        return tieneReservaHotel && tieneComida && tieneBoleto && tieneTransporte;
    }

    private boolean tienePromoReservaBoleto() {
        long countReservaHotel = this.paquete.stream().filter(p -> p.getCategoria() == ProductoTypes.RESERVA_HOTEL).count();
        long countBoleto = this.paquete.stream().filter(p -> p.getCategoria() == ProductoTypes.BOLETO).count();

        return countReservaHotel >= 2 && countBoleto >= 2;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", paquete=" + paquete +
                ", precio=" + precio +
                '}';
    }
}
