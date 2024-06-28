import java.time.LocalDateTime;

public class Comida extends Reserva {

    private LocalDateTime fechaReserva;
    private String nombreRestaurante;

    public Comida(int valor, int reservaId, LocalDateTime fechaReserva, String nombreRestaurante) {
        super(valor, reservaId);
        this.fechaReserva = fechaReserva;
        this.nombreRestaurante = nombreRestaurante;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "fechaReserva=" + fechaReserva +
                ", nombreRestaurante='" + nombreRestaurante + '\'' +
                ", valor=" + getValor() +
                '}';
    }
}
