public class Vaca extends Animal implements Hervivoro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerAnimal() {
        this.comerHierva();
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo hierva");
    }
}
