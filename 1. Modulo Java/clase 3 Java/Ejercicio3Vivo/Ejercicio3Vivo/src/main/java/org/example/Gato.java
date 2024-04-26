package org.example;

public class Gato extends Animal implements ICarnivoro,IHervioro{
    @Override
    protected void emitirSonido() {
        System.out.println("Miau ");
    }

    @Override
    protected void comer() {
        this.comerCarne();
        this.comerHierba();
    }


    @Override
    public void comerCarne() {
        System.out.println("Soy un gato que come carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy un gato que come hierba");
    }
}
