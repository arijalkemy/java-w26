package ejercicio2;

public class Perecedero extends Producto{
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    @Override
    public double calcularPrecio(int cantidadProductos){
        double precio =super.calcularPrecio(cantidadProductos);
        switch (diasPorCaducar){
            case 1:
                precio /=4;
                break;
            case 2:
                precio /=3;
            break;
            case 3:
                precio /=2;
                break;
        }
        return precio;
    }
}
