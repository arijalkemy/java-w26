public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("La vaca hace: muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba.");
    }
}