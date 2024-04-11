package org.example.EjercicioTres.ClasesAnimales;

import org.example.EjercicioTres.InterfacesAnimales.Carnivoros;

public class Gato extends Animal implements Carnivoros {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo atun");
    }


}
