public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    public void comerHierba(){
        System.out.println("La vaca come pasto.");
    }
}
