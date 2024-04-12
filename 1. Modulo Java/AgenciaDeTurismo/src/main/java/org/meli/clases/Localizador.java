package org.meli.clases;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservaList;
    private Double total;
    private Double totalSinDescuento = 0.0;

    private Double descuento = 0.0;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservaList = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservaList.add(reserva);
    }

    public void calcularTotal() {
        int contadorHotel = 0;
        int contadorComida = 0;
        int contadorBoletoVuelo = 0;
        int contadorTransporte = 0;
        for (Reserva reserva : reservaList) {
            this.totalSinDescuento += reserva.valor;
            if (reserva.tipo.equals("Hotel")) {
                contadorHotel++;
            } else if (reserva.tipo.equals("Comida")) {
                contadorComida++;
            } else if (reserva.tipo.equals("Boletovuelo")) {
                contadorBoletoVuelo++;
            } else if (reserva.tipo.equals("Transporte")) {
                contadorTransporte++;
            }
        }
        if (contadorHotel > 0 && contadorComida > 0 && contadorBoletoVuelo > 0 && contadorTransporte > 0) {
            this.descuento += 0.1;
        }
        if (contadorHotel> 1 && contadorBoletoVuelo > 1) {
            this.descuento += 0.050;
        }
    }

    public void agregarDescuento(Double descuento) {
        this.descuento += descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void aplicarDescuento() {
        this.total = this.totalSinDescuento-(this.totalSinDescuento * this.descuento);
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        String reservas = "";
        int descuentoPorcentaje = (int)(descuento* -100);
        for (Reserva reserva : this.reservaList) {
            reservas += reserva.toString() + "\n";
        }
        return ""+ this.cliente.toString() + "\n" + reservas + "Total: $" + this.totalSinDescuento + "\nDescuento: " + descuentoPorcentaje+ "%\nTotal con descuentos: $" + this.total;
    }
}
