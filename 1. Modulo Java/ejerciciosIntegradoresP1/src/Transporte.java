import java.time.LocalDate;

public class Transporte extends Reserva  {


    private LocalDate fechaReserva;

    public Transporte(int valor, int reservaId, LocalDate fechaReserva) {
        super(valor, reservaId);
        this.fechaReserva = fechaReserva;
    }


    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "fechaReserva=" + fechaReserva +
                ", valor=" + getValor() +
                '}';
    }
}
