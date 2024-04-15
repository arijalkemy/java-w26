package ClasesAbstractasInterfaces.Animales.animales;

public class Vaca extends Animal implements Herviboro{
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca comio su hierba");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
