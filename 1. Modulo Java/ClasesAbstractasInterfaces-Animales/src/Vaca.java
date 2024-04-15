public class Vaca extends Animal implements IHerviboro {
    public Vaca() {
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }

    @Override
    public void comerAnimal() {
        comerHierba();
    }
}
