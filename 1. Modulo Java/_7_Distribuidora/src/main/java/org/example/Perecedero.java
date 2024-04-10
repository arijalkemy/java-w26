package org.example;

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

    public String toString(){
        return "El nombre es " + super.getPrecio() + ". El precio es: " + super.getPrecio() + ". Los dias para caducar son: " + this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar){
            case 1:
                return resultado * 0.25;
            case 2:
                return resultado * 0.33;
            case 3:
                return resultado * 0.5;
        }
        return resultado;
    }
}
