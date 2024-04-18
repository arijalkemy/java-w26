package distribuidora.parte2;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" + "diasPorCaducar=" + diasPorCaducar + '}';
    }

    @Override
    public double calcular(int cantidadProductos) {
        try {
            double result = super.calcular(cantidadProductos);
            switch (this.diasPorCaducar) {
                case 1:
                    return result / 4;
                case 2:
                    return result / 3;
                case 3:
                    return result / 2;
                default:
                    return result;
            }
        }
        catch (Exception e) {
            throw new Error("Error al hacer los calculos" + e);
        }
    }
}
