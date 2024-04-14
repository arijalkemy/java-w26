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
        return super.toString() + "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar) {
            case 1:
                super.setPrecio(this.getPrecio() - super.getPrecio() * 4);
                break;
            case 2:
                super.setPrecio(this.getPrecio() - super.getPrecio() * 3);
                break;
            case 3:
                super.setPrecio(this.getPrecio() - super.getPrecio()/2);
                break;
        }
        return super.calcular(cantidadDeProductos);
    }
}
