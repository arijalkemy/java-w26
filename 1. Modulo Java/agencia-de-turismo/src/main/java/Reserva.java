public class Reserva {
    private Double precio;
    private String tipoReserva;

    public Reserva(Double precio, String tipoReserva) {
        this.precio = precio;
        this.tipoReserva = tipoReserva;
    }

    public String getTipoReserva() {
        return this.tipoReserva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", tipoReserva='" + tipoReserva + '\'' +
                '}';
    }
}
