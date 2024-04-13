import java.util.HashMap;
import java.util.Map;

class Localizador {
    private Cliente cliente;
    private Map<String, Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new HashMap<>();
        this.total = 0.0;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.put(reserva.getTipo(), reserva);
        total += reserva.getCosto();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Map<String, Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setReservas(Map<String, Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean contieneReserva(String hotel) {
        return true;
    }
}

