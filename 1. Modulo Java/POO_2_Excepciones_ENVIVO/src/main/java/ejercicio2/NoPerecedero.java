package ejercicio2;

public class NoPerecedero extends Producto{
    String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
    public double calcularPrecio(int cantidadProductos) {
        return precio * cantidadProductos;
    }
}
