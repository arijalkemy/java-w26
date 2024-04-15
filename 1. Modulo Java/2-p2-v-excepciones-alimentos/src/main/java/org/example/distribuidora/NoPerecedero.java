package org.example.distribuidora;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    /*
    //Este método se puede obviar ya que si no encuentra el metodo en esta clase, va a buscar la de la clase padre
    @Override
    public double calcular(int cantidadDeProductos){
        return super.calcular(cantidadDeProductos);
    }
     */

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
