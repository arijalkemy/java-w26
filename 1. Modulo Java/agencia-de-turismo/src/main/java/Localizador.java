import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;


    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.total = getTotal();
        if (this.reservas.size() >= 4) {
            this.aplicarDescuentoPaqueteCompleto();
        }
    }

    public boolean comproPaqueteCompleto() {
        boolean comproPaqueteCompleto=false;
        boolean tieneHotel = false;
        boolean tieneBoletos = false;
        boolean tieneComida = false;
        boolean tieneTransporte = false;

        for (Reserva r : this.getReservas()) {
            switch (r.getTipoReserva()) {
                case "hotel":
                    tieneHotel = true;
                    break;
                case "boletos":
                    tieneBoletos = true;
                    break;
                case "comida":
                    tieneComida = true;
                    break;
                case "transporte":
                    tieneTransporte = true;
                    break;

            }
        }
        if(tieneHotel && tieneComida && tieneTransporte && tieneBoletos){
          comproPaqueteCompleto=true;
        }
        return comproPaqueteCompleto;
    }



    public void aplicarDescuentoPaqueteCompleto() {
        if (this.comproPaqueteCompleto()) {
            this.total -= total*0.10;
        }
    }
    public double getTotal() {
        return this.reservas.stream().mapToDouble(r -> r.getPrecio()).sum();
    }

    @Override
    public String toString() {

        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    public void setTotal(double total) {
        this.total = total;
    }
}


