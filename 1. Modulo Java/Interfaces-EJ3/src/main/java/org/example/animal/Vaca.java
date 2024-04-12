package org.example.animal;

import org.example.interfaces.HerviboroImpl;

public class Vaca extends Animal implements HerviboroImpl {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Como hierba");
    }
}
