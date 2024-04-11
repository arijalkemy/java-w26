package org.main;

public class Perecedero extends Producto{
    private Integer diasPorCaducar;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "dias por caducar='" + this.diasPorCaducar + '\'' +
                "nombre'"+super.getNombre()+'\''+
                "precio'"+super.getPrecio()+'\''+
                '}';
    }

    @Override
    public Double calcular(Integer cantidadDeProductos){
        if(this.diasPorCaducar<=1){
            return super.calcular(cantidadDeProductos) /4;
        }else if(this.diasPorCaducar<=2){
            return super.calcular(cantidadDeProductos) /3;
        }else if(this.diasPorCaducar<=3){
            return super.calcular(cantidadDeProductos) /2;
        }else {
            return super.calcular(cantidadDeProductos);
        }
    }
}
