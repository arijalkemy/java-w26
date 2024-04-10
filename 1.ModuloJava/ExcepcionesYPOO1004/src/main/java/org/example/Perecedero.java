package org.example;

public class Perecedero extends Producto{
    private int diasPorCadudcar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public Perecedero(String nombre, double precio, int diasPorCadudcar) {
        super(nombre, precio);
        this.diasPorCadudcar = diasPorCadudcar;
    }

    public int getDiasPorCadudcar() {
        return diasPorCadudcar;
    }

    public void setDiasPorCadudcar(int diasPorCadudcar) {
        this.diasPorCadudcar = diasPorCadudcar;
    }

    @Override
    public void calcular(int cantidad) {
        double resultado = cantidad* this.getPrecio();
        if(this.diasPorCadudcar==1){
            resultado= resultado*0.25;
        }else if (this.diasPorCadudcar==2){
            resultado = resultado *0.3;
        } else if (this.diasPorCadudcar==3) {
            resultado = resultado *0.5;
        }
        System.out.println("El precio de "+ cantidad +" de " + super.getNombre() +"es igual a " + resultado);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCadudcar=" + diasPorCadudcar +
                '}';
    }
}
