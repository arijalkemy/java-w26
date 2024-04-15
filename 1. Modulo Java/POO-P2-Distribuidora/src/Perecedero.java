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
        return "Producto Perecedero: "+super.toString() +"diasPorCaducar=" + diasPorCaducar + '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if(diasPorCaducar == 1) return cantidadDeProductos * (this.precio/4);

        if(diasPorCaducar == 2) return  cantidadDeProductos*(this.precio/3);

        if(diasPorCaducar == 3) return cantidadDeProductos*(this.precio/2);

        return this.precio * cantidadDeProductos;
    }
}
