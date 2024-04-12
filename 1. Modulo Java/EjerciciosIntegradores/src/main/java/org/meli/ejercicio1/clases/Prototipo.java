package org.meli.ejercicio1.clases;

public abstract class Prototipo<T extends  Number>{
    public static Number contador = 0;
    public static Integer incrementador = 2;
    public static Number siguienteNumero() {
        contador = contador.intValue() + incrementador;
        return contador;
    }
    public static void reiniciarContador() {
        contador = 0;
    }
    public void establecerContador(Number valor) {
        contador = valor;
        if(valor.intValue()>2){
            incrementador = valor.intValue();
        }
    }
}
