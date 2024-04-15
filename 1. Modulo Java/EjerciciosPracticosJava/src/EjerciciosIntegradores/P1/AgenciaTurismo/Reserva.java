package EjerciciosIntegradores.P1.AgenciaTurismo;

public class Reserva {
    private static int reserva;
    private int idReserva;
    private Producto producto;
    private double costo;
    private boolean descuentoAplicado = false;

    public Reserva(Producto producto) {
        Reserva.reserva++;
        this.idReserva = Reserva.reserva;
        this.producto = producto;
        this.costo = this.producto.getPrecio();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
        this.descuentoAplicado = true;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reserva{");
        sb.append("idReserva=").append(idReserva);
        sb.append(", producto=").append(producto);
        sb.append(", costo=").append(costo);
        sb.append('}');
        return sb.toString();
    }
}
