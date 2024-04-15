package org.example.EjercicioTres.ClasesAnimales;

import org.example.EjercicioTres.InterfacesAnimales.Carnivoros;

public class Perro extends Animal implements Carnivoros {
    @Override
    public void hacerSonido() {
        System.out.println("Guaou");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

}
