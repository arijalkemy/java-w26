public class Vaca extends Animal implements Herviboro{
    @Override
    void hacerSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca comer hierbas.");
    }
}
