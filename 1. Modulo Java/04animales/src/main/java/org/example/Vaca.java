package org.example;

public class Vaca extends Animal implements ICarnivoro, IHerbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comerCarne() {
        System.out.println("* mastica carne y digiere con sus 4 estómagos *");
    }

    @Override
    public void comerHierba() {
        System.out.println("* rumiando hierba * ");

    }
}
