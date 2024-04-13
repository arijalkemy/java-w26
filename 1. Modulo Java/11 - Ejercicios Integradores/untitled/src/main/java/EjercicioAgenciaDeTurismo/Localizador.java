package EjercicioAgenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> paquete;
    private Double costoTotal;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.costoTotal = 0.0;
        this.paquete = new ArrayList<>();

    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<Reserva> paquete) {
        this.paquete = paquete;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        String reservaString = "";
        for (Reserva reserva: paquete) {
            reservaString += reserva.toString();
        }

        return "Localizador{" +
                "cliente=" + cliente.toString() +
                ", paquete=" +  reservaString+
                ", total= " + costoTotal+
                '}';
    }

    public void agregarReserva(Reserva reserva)
    {

        this.paquete.add(reserva);
        costoTotal += reserva.getPrecio();
    }

    


}
