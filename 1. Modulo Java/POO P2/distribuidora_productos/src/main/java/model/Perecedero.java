package model;


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
        return super.toString() + "  Dias por caducar: " + diasPorCaducar + "\n";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar){
            case 1: return (super.getPrecio()/4) * cantidadDeProductos;
            case 2: return (super.getPrecio()/3) * cantidadDeProductos;
            case 3: return (super.getPrecio()/2) * cantidadDeProductos;
            default: return super.getPrecio() * cantidadDeProductos;
        }
    }
}
