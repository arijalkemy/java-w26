public class NoPerecedero extends Producto{
    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public NoPerecedero(String nombre, double precio, String tipo){
        super(nombre,precio);
        this.tipo = tipo;
    }
    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}
