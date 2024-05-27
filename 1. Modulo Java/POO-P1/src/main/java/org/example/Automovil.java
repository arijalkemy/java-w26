package org.example;

public class Automovil { //Se modifica nombre para respetar convención



    //Atributos
        String marca;
        String color;
        double kilometros;

        //Construcctor vacio
        public Automovil() {
        }
        //Constructor con parametros
        public Automovil(String marca, String color, double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
        }

        public String mostrarMarcaYColor() {
            String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            return marcaYColor;
        }
}
