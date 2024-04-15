package org.example;
//Clase del objeto NoPerecedero hereda de producto
public class NoPerecedero extends Producto{
    private String tipo; //Atributo

    //Constructor de clase
    public NoPerecedero(String nombre, double precio,String tipo) {
        super(nombre, precio);
        this.tipo=tipo;
    }
    //Metodo getter y setter de la clase
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //Metodo toString de la clase
    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
    //Metodo calcular el cual solo llama el metodo super de la super clase que herada
    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
