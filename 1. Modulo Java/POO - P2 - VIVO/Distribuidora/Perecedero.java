public class Perecedero extends Producto {
    private int diasxCaducar;

    public Perecedero(int diasxCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasxCaducar = diasxCaducar;
    }

    public int getDiasxCaducar() {
        return diasxCaducar;
    }

    public void setDiasxCaducar(int diasxCaducar) {
        this.diasxCaducar = diasxCaducar;
    }

    @Override
    public double calcular(int cantProductos) {
        switch (diasxCaducar) {
            case 1:
                return super.getPrecio() * cantProductos / 4;
            case 2:
                return super.getPrecio() * cantProductos / 3;
            case 3:
                return super.getPrecio() * cantProductos / 2;
            default:
                return super.getPrecio() * cantProductos;
        }
    }

    @Override
    public String toString() {
        return super.toString()+" Perecedero{" +
                "diasxCaducar=" + diasxCaducar +
                '}';
    }
}
