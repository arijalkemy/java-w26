public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre,precio);
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar){
            case 1:
                precioFinal /= 4;
                break;
            case 2:
                precioFinal /= 3;
                break;
            case 3:
                precioFinal /= 2;
                break;
            default:
                break;
        }
        return precioFinal;
    }
}
