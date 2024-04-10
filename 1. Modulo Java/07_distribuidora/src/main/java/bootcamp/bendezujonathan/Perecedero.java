package bootcamp.bendezujonathan;

import java.util.Map;

public class Perecedero extends Producto {

    private int diasACaducar;
    
    private static final Map<Integer, Double> DISCOUNT = Map.of(1, 0.25,
    2, 1 / 3D,
    3, 0.50);

    public Perecedero(String nombre, double precio, int diasACaducar) {
        super(nombre, precio);
        this.diasACaducar = diasACaducar;
    }

    @Override
    public double calcular(int cantidad) {
        return cantidad * this.calculateDiscount();
    }

    private double calculateDiscount() {
        return this.getPrecio() * DISCOUNT.getOrDefault(this.diasACaducar, 1D);
    }

    public int getDiasACaducar() {
        return this.diasACaducar;
    }

    public void setDiasACaducar(int diasACaducar) {
        this.diasACaducar = diasACaducar;
    }

}
