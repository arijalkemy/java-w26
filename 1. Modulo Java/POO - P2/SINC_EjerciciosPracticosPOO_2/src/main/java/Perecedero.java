public class Perecedero extends Producto {
    private int diasPorCaducar;

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
        return super.toString() + "Dias por caducar: " + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProducto) {
        switch (this.diasPorCaducar) {
            case 1: return super.calcular(cantidadDeProducto)/4;
            case 2: return super.calcular(cantidadDeProducto)/3;
            case 3: return super.calcular(cantidadDeProducto)/2;
            default: return -1;
        }
    }
}
