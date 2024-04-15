package POO.P2.Distribuidora;

public class NoPedecedero extends Producto{
    private String tipo;

    public NoPedecedero(String nombre, double precio, String tipo) {
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
        return "NoPedecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
