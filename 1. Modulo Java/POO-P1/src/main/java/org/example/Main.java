package org.example;

public class Main {
    public static void main(String[] args) {
        //Creando una instancia de automovil
       Automovil automovil = new Automovil("Volvo","Negro",5);

       //Utilizando la función
        System.out.println(automovil.mostrarMarcaYColor());
    }
}
