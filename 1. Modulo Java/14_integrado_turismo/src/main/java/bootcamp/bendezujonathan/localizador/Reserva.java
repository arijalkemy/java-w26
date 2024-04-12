package bootcamp.bendezujonathan.localizador;

public class Reserva {
    private int id;
    private String descripcion;
    private Producto producto;
    private double precioUnitario;
    private int cantidad;

    public Reserva(int id, String descripcion, Producto producto, double precioUnitario, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public double calcularTotal(){
        return this.precioUnitario * cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", descripcion=" + descripcion + ", producto=" + producto + ", precioUnitario="
                + precioUnitario + ", cantidad=" + cantidad + "]";
    }

}
