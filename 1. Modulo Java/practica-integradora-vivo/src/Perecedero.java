public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar){
            case 1 :
                return (getPrecio() * cantidadDeProductos) / 4;
            case 2 :
                return (getPrecio() * cantidadDeProductos) / 3;
            case 3:
                return (getPrecio() * cantidadDeProductos) / 2;
            default:
                return 0;
        }
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
