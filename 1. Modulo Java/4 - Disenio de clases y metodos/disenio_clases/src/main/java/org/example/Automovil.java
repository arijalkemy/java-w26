package org.example;

//El nombre de la clase debe empezar con mayuscula y le faltaba la palabra reservada class
public class Automovil {

        String marca;
        String color;
        double kilometros;
        /* Este constructor no hace nada, y no es necesario ya que java crea uno por default
public Automovil() {

        }*/
//Faltaba definir los tipos de datos en los argumentos del constructor
public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
        }
//En este metodo faltaba el return, el cual se definio que debia ser de tipo String
public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
        }
}
