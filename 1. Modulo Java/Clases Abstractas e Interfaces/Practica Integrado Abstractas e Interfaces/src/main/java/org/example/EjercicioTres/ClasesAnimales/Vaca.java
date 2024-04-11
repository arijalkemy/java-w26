package org.example.EjercicioTres.ClasesAnimales;

import org.example.EjercicioTres.InterfacesAnimales.Herviboros;

public class Vaca extends Animal implements Herviboros {
    @Override
    public void hacerSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
}
