package org.example.AbstractClass_Interfaces.Ejercicio_3;

import org.example.AbstractClass_Interfaces.Ejercicio_3.Animales.Gato;
import org.example.AbstractClass_Interfaces.Ejercicio_3.Animales.Perro;
import org.example.AbstractClass_Interfaces.Ejercicio_3.Animales.Vaca;
import org.example.AbstractClass_Interfaces.Ejercicio_3.Services.Comer;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        List<Comer> animales = List.of(perro, gato, vaca);
        animales.forEach(Comer::comer);


    }
}
