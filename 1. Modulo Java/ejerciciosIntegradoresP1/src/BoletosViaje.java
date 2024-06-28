import java.time.LocalDate;

public class BoletosViaje extends Reserva  {

    private String nombreAerolinea;
    private LocalDate fechaVueloIda;
    private LocalDate fechaVueloRegreso;

    public BoletosViaje(int valor, int reservaId, String nombreAerolinea, LocalDate fechaVueloIda, LocalDate fechaVueloRegreso) {
        super(valor, reservaId);
        this.nombreAerolinea = nombreAerolinea;
        this.fechaVueloIda = fechaVueloIda;
        this.fechaVueloRegreso = fechaVueloRegreso;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public LocalDate getFechaVueloIda() {
        return fechaVueloIda;
    }

    public void setFechaVueloIda(LocalDate fechaVueloIda) {
        this.fechaVueloIda = fechaVueloIda;
    }

    public LocalDate getFechaVueloRegreso() {
        return fechaVueloRegreso;
    }

    public void setFechaVueloRegreso(LocalDate fechaVueloRegreso) {
        this.fechaVueloRegreso = fechaVueloRegreso;
    }

    @Override
    public String toString() {
        return "BoletosViaje{" +
                "nombreAerolinea='" + nombreAerolinea + '\'' +
                ", fechaVueloIda=" + fechaVueloIda +
                ", fechaVueloRegreso=" + fechaVueloRegreso +
                ", valor=" + getValor() +
                '}';
    }
}
