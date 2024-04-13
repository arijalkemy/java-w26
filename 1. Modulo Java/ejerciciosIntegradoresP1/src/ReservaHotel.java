import java.time.LocalDate;
import java.util.Objects;

public class ReservaHotel extends Reserva  {

    private String nombreHotel;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public ReservaHotel(int valor, int reservaId, String nombreHotel, LocalDate fechaIngreso, LocalDate fechaSalida) {
        super(valor, reservaId);
        this.nombreHotel = nombreHotel;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "nombreHotel='" + nombreHotel + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                ", valor=" + getValor() +
                '}';
    }
}
