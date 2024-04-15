package POO.P2.Distribuidora;

public class Pedecedero extends Producto{
    private int diasPorCaducar;

    public Pedecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Pedecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        int divisor = diasPorCaducar == 1 ? 4 : diasPorCaducar == 2 ? 3 : diasPorCaducar == 3 ? 2 : 1;
        return super.calcular(cantidadDeProductos) / divisor;
    }
}