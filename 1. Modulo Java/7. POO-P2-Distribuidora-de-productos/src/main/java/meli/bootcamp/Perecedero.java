package meli.bootcamp;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
        return super.toString() + ", Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar) {
            case 1:
                return super.calcular(cantidadDeProductos) / 4;
            case 2:
                return super.calcular(cantidadDeProductos) / 3;
            case 3:
                return super.calcular(cantidadDeProductos) / 2;
            default:
                return super.calcular(cantidadDeProductos);
        }
    }
}
