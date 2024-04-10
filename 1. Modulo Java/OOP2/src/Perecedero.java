public class Perecedero extends Producto{
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
    public double calcular(int cantidadDeProductos) {
        double base = super.calcular(cantidadDeProductos);
        return switch (this.diasPorCaducar) {
            case 3 -> base / 2;
            case 2 -> base / 3;
            case 1 -> base / 4;
            default -> base;
        };
    }

    @Override
    public String toString(){
        return super.toString() + ". Días por caducar: " + this.diasPorCaducar + ".";
    }
}
