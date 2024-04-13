package com.meli;

public class Perecedero extends Producto {
    private Integer diasPorCalcular;

    public Perecedero(String nombre, Double precio, Integer diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    public Integer getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(Integer diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public Double calcular(Integer cantidadDeProductos) {
        Double precioInicial = getPrecio();
        switch (diasPorCalcular) {
            case 1:
                setPrecio(precioInicial / 4);
                break;
            case 2:
                setPrecio(precioInicial / 3);
                break;
            case 3:
                setPrecio(precioInicial / 2);
                break;
            default:
                System.out.println("No se puede calcular el precio del dia");
        }
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return "Perecedero = " +
                "diasPorCalcular=" + diasPorCalcular;
    }
}
