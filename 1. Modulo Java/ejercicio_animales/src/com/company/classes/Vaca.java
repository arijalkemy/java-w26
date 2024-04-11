package com.company.classes;

import com.company.interfaces.IHerbivoro;

public class Vaca extends Animal implements IHerbivoro {
    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba.");
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }
}
