package EjerciciosIntegradores.Supermercado;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Item(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
}
